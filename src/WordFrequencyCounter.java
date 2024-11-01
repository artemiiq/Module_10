import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class WordFrequencyCounter {
    public static void countWordFrequency(String fileName) {
        Map<String, Integer> frequencyMap = new HashMap<String, Integer>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine())!= null) {
                String[] words = line.toLowerCase().split("\\s+");
                for (String word : words) {
                    frequencyMap.put(word, frequencyMap.getOrDefault(word,0) + 1);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file " + e.getMessage());
        }

        List<Map.Entry<String, Integer>> sortedWordList = new ArrayList<>(frequencyMap.entrySet());
        sortedWordList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
