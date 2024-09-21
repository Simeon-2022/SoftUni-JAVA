package _10_Streams_Files_and_Directories_Exercise;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class _04_CountCharacterTypes {
    public static void main(String[] args) throws IOException {

        String root = "src/_10_Streams_Files_and_Directories_Exercise/input.txt";
        String destination = "src/_10_Streams_Files_and_Directories_Exercise/output.txt";

        String content = Files.readString(Path.of(root));

        content = content.replaceAll("\\s+", "");
        
        int countVowels = 0;
        int countOtherSymbols = 0;
        int countPunctuation = 0;

        for (char symbol : content.toCharArray()) {
            
            if (isVowel(symbol)) {
               countVowels++;
            } else if (isPunctuation(symbol)) {
                countPunctuation++;
            } else {
                countOtherSymbols++;
            }
        }

        PrintWriter printWriter = new PrintWriter(new FileOutputStream(destination));

        printWriter.printf("Vowels: %d%n" +
                "Other symbols: %d%n" +
                "Punctuation: %d", countVowels, countOtherSymbols, countPunctuation);

        printWriter.close();
    }

    private static boolean isPunctuation(char symbol) {

        return symbol == '!' || symbol == ',' || symbol == '.' || symbol == '?';
    }

    private static boolean isVowel(char symbol) {
        return symbol == 'a' || symbol == 'e' || symbol == 'i' || symbol == 'o' || symbol == 'u';
    }
}
