package _10_Streams_Files_and_Directories_Exercise;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class _07_MergeTwoFiles {
    public static void main(String[] args) throws IOException {

        String inputOne = "src/_10_Streams_Files_and_Directories_Exercise/inputOne.txt";
        String inputTwo = "src/_10_Streams_Files_and_Directories_Exercise/inputTwo.txt";
        String destination = "src/_10_Streams_Files_and_Directories_Exercise/output.txt";

        String textOne = Files.readString(Path.of(inputOne));
        String textTwo = Files.readString(Path.of(inputTwo));

        PrintWriter writer = new PrintWriter(destination);

        writer.println(textOne);
        writer.println(textTwo);
        writer.close();

    }
}
