package Хеширование;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = reader.readLine();
        String[] words = line.split(" ");

        Map<String, Integer> wordCounts = new HashMap<>();
        for (String word : words) {
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }

        String mostFrequentWord = "";
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            String word = entry.getKey();
            int count = entry.getValue();

            if (count > maxCount) {
                mostFrequentWord = word;
                maxCount = count;
            } else if (count == maxCount && word.compareTo(mostFrequentWord) < 0) {
                mostFrequentWord = word;
            }
        }

        writer.write(mostFrequentWord);
        writer.newLine();

        reader.close();
        writer.close();
    }
}
