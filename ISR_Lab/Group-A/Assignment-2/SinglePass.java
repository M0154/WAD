
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SinglePass {
    
    public static void main(String[] args) throws IOException {
        BufferedReader stdInpt = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number of Tokens:");
        int noOfDocuments = Integer.parseInt(stdInpt.readLine());
        System.out.println("Enter the number of Documents:");
        int noOfTokens = Integer.parseInt(stdInpt.readLine());
        System.out.println("Enter the threshold:");
        float threshold = Float.parseFloat(stdInpt.readLine());
        System.out.println("Enter the Document Token Matrix:");
        
        int[][] input = new int[noOfDocuments][noOfTokens];
        for (int i = 0; i < noOfDocuments; i++) {
            for (int j = 0; j < noOfTokens; j++) {
                System.out.println("Enter (" + i + "," + j + "):");
                input[i][j] = Integer.parseInt(stdInpt.readLine());
            }
        }
        
        SinglePassAlgorithm(noOfDocuments, noOfTokens, threshold, input);
    }
    
    private static void SinglePassAlgorithm(int noOfDocuments, int noOfTokens, float threshold, int[][] input) {
        int[][] cluster = new int[noOfDocuments][noOfDocuments + 1];
        ArrayList<Float[]> clusterRepresentative = new ArrayList<>();
        cluster[0][0] = 1;
        cluster[0][1] = 0;
        int noOfClusters = 1;
        
        Float[] temp = new Float[noOfTokens];
        temp = convertIntArrToFloatArr(input[0]);
        clusterRepresentative.add(temp);
        
        for (int i = 1; i < noOfDocuments; i++) {
            float max = -1;
            int clusterId = -1;
            for (int j = 0; j < clusterRepresentative.size(); j++) {
                float similarity = calculateSimilarity(convertIntArrToFloatArr(input[i]), clusterRepresentative.get(j));
                if (similarity > threshold) {
                    if (similarity > max) {
                        max = similarity;
                        clusterId = j;
                    }
                }
            }
            
            if (max == -1) {
                cluster[noOfClusters][0] = 1;
                cluster[noOfClusters][1] = i;
                noOfClusters++;
                clusterRepresentative.add(convertIntArrToFloatArr(input[i]));
            } else {
                cluster[clusterId][0] += 1;
                int index = cluster[clusterId][0];
                cluster[clusterId][index] = i;
                clusterRepresentative.set(clusterId, calculateClusterRepresentative(cluster[clusterId], input, noOfTokens));
            }
        }
        
        for (int i = 0; i < noOfClusters; i++) {
            System.out.print("\n" + i + "\t");
            for (int j = 1; j <= cluster[i][0]; j++) {
                System.out.print(" " + cluster[i][j]);
            }
        }
    }
    
    private static Float[] convertIntArrToFloatArr(int[] input) {
        int size = input.length;
        Float[] answer = new Float[size];
        for (int i = 0; i < size; i++) {
            answer[i] = (float) input[i];
        }
        return answer;
    }
    
    private static float calculateSimilarity(Float[] a, Float[] b) {
        float answer = 0;
        for (int i = 0; i < a.length; i++) {
            answer += a[i] * b[i];
        }
        return answer;
    }
    
    private static Float[] calculateClusterRepresentative(int[] cluster, int[][] input, int noOfTokens) {
        Float[] answer = new Float[noOfTokens];
        for (int i = 0; i < noOfTokens; i++) {
            answer[i] = Float.parseFloat("0");
        }
        for (int i = 1; i <= cluster[0]; i++) {
            for (int j = 0; j < noOfTokens; j++) {
                answer[j] += input[cluster[i]][j];
            }
        }
        for (int i = 0; i < noOfTokens; i++) {
            answer[i] /= cluster[0];
        }
        return answer;
    }
}
