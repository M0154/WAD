import java.util.HashSet;
import java.util.Set;

public class B1_PrecisionRecallCalculator {

    // Method to calculate precision and recall
    public static void calculatePrecisionRecall(Set<String> retrievedDocs, Set<String> relevantDocs) {
        // Edge case: If no documents are retrieved, precision is undefined, set to 0
        if (retrievedDocs.isEmpty()) {
            System.out.println("Precision: 0.00");
            System.out.println("Recall: 0.00");
            //System.out.println("F1 Score: 0.00");
            return;
        }

        // Calculate true positives (intersection of retrieved and relevant documents)
        Set<String> truePositives = new HashSet<>(retrievedDocs);
        truePositives.retainAll(relevantDocs);

        // Precision: True Positives / Retrieved Documents
        double precision = (double) truePositives.size() / retrievedDocs.size();

        // Recall: True Positives / Relevant Documents
        double recall = relevantDocs.isEmpty() ? 0 : (double) truePositives.size() / relevantDocs.size();

        // F1 Score: 2 * (Precision * Recall) / (Precision + Recall)
        double f1Score = (precision + recall == 0) ? 0 : 2 * (precision * recall) / (precision + recall);

        // Print the results
        System.out.printf("Precision: %.2f%n", precision);
        System.out.printf("Recall: %.2f%n", recall);
        //System.out.printf("F1 Score: %.2f%n", f1Score);
    }

    public static void main(String[] args) {
        // Sample input for query q1
        Set<String> retrievedDocs = new HashSet<>();
        retrievedDocs.add("doc1");
        retrievedDocs.add("doc2");
        retrievedDocs.add("doc3");
        retrievedDocs.add("doc4");
       
        Set<String> relevantDocs = new HashSet<>();
        relevantDocs.add("doc2");
        relevantDocs.add("doc3");
        relevantDocs.add("doc5");
       
        // Call the function to calculate precision and recall
        calculatePrecisionRecall(retrievedDocs, relevantDocs);
    }
}






