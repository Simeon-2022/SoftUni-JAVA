package _10_Streams_Files_and_Directories_Exercise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class _01_SumLines {
    public static void main(String[] args) throws IOException {

        String root = "D:\\Projects\\Git_projects\\JAVA\\SoftUni-JAVA\\_03_Java_Advanced_May_2024\\src\\_10_Streams_Files_and_Directories_Exercise\\input.txt";
        //BufferedReader reader = new BufferedReader(new FileReader(root ));

        List<String> lines = Files.readAllLines(Path.of(root)); // Utility class

        for (String line : lines) {
            int lineCharSum = 0;

            for (char symbol : line.toCharArray()) {
                lineCharSum += symbol;
            }
            System.out.println(lineCharSum);
        }
    }
}
