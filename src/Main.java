import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        String inputFilePath = "src\\words.txt";
        String outputFilePath = "5letters.txt";

        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))
        ) {
            String word;
            while ((word = reader.readLine()) != null) {
                if (isValidWord(word)) {
                    writer.write(word);
                    writer.newLine();
                }
            }
            System.out.println("Words have been filtered and written to " + outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isValidWord(String word) {
        
        return word.length() == 5 && word.matches("[a-zA-Z]+");
    }
}
