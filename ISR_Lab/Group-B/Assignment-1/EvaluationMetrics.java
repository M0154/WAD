import java.util.Scanner;

public class EvaluationMetrics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter True Positives (TP): ");
        double TP = scanner.nextDouble();

        System.out.print("Enter False Positives (FP): ");
        double FP = scanner.nextDouble();

        System.out.print("Enter False Negatives (FN): ");
        double FN = scanner.nextDouble();

        System.out.print("Enter Beta (for E Measure): ");
        double beta = scanner.nextDouble();

        double precision = TP / (TP + FP);
        double recall = TP / (TP + FN);
        double f1Score = 2 * (precision * recall) / (precision + recall);
        double eMeasure = (1 + beta * beta) * (precision * recall) / ((beta * beta * precision) + recall);

        System.out.println("\nPrecision: " + precision);
        System.out.println("Recall: " + recall);
        System.out.println("F1 Score: " + f1Score);
        System.out.println("E Measure: " + eMeasure);

        scanner.close();
    }
}
