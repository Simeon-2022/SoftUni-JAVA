package _10_Streams_Files_and_Directories_Exercise;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class _05_LineNumbers {
    public static void main(String[] args) throws IOException {

        String input = "src/_10_Streams_Files_and_Directories_Exercise/inputLineNumbers.txt";
        String destination = "src/_10_Streams_Files_and_Directories_Exercise/output.txt";

        List<String> lines = Files.readAllLines(Path.of(input));



        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(destination));

        int count = 0;
        for (String line : lines) {
            count++;
            bufferedWriter.write( count + ". " + line + System.lineSeparator());
            bufferedWriter.flush();
        }

     //   bufferedWriter.close();
    }
}
