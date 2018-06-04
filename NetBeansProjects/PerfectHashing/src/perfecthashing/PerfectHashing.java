
package perfecthashing;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class PerfectHashing {

    private static HashMap<String, ArrayList<Integer>> wordOccurences = new HashMap<>();

    private static String pathToFile = "/Users/marzan/Downloads/Agora-2.docx";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(pathToFile))) {

            int line = 1;

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                String[] words = currentLine.split("\\W+");

                for (String word : words) {
                    word = word.toLowerCase();
                    ArrayList<Integer> list = wordOccurences.get(word);
                   

                    if (list == null) {
                        list = new ArrayList<>();
                        wordOccurences.put(word, list);
                    }

                    list.add(line);
                }

                line++;
            }

            System.out.println(wordOccurences.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
