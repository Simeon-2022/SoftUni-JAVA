package _10_Streams_Files_and_Directories_Exercise;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;

public class _06_WordCount {
    public static void main(String[] args) throws IOException {

        String input = "src/_10_Streams_Files_and_Directories_Exercise/words.txt";
        String source = "src/_10_Streams_Files_and_Directories_Exercise/text.txt";
        String destination = "src/_10_Streams_Files_and_Directories_Exercise/output.txt";

        String[] words = Files.readString(Path.of(input)).split("\\s+");
        String text = Files.readString(Path.of(source));

        Map<String, Integer> wordCount = new LinkedHashMap<>();

        for (String word : words) {

            wordCount.putIfAbsent(word, 0);
        }

        for (String str : text.split("\\s+")) {

            if (wordCount.containsKey(str)) {

                wordCount.put(str, wordCount.get(str) + 1);

            }
        }

        PrintWriter printWriter = new PrintWriter(new FileOutputStream(destination));
 /*       for (Map.Entry<String, Integer> wordEntry : wordCount.entrySet()) {

            printWriter.printf("%s - %d%n", wordEntry.getKey(), wordEntry.getValue());
            printWriter.flush();
        }
*/

        wordCount.forEach((key, value) -> printWriter.printf("%s - %d%n", key, value));
        printWriter.close();
    }
}
