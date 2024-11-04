import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SinglePassWordFrequency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file path: ");
        String fileName = scanner.nextLine();

        Map<String, Integer> wordCount = new HashMap<>();

        try {
            Scanner fileScanner = new Scanner(new File(fileName));
            while (fileScanner.hasNext()) {  // Single pass through the file
                String word = fileScanner.next().toLowerCase();
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }

        // Output the word frequencies
        wordCount.forEach((word, frequency) -> System.out.println(word + " : " + frequency));

        scanner.close();
    }
}
