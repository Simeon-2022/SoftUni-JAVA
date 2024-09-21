package _09_Streams_Files_and_Directories_Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class _02_WriteToFile {

    public static void main(String[] args) throws IOException {

        String path = "D:\\Projects\\Git_projects\\JAVA\\SoftUni-JAVA\\_03_Java_Advanced_May_2024\\src\\_09_Streams_Files_and_Directories_Lab\\input.txt";
        String pathTo = "D:\\Projects\\Git_projects\\JAVA\\SoftUni-JAVA\\_03_Java_Advanced_May_2024\\src\\_09_Streams_Files_and_Directories_Lab\\02.WriteToFileOutput.txt";

        FileInputStream in = new FileInputStream(path);
        FileOutputStream out = new FileOutputStream(pathTo);
        Scanner scanner = new Scanner(in);

        StringBuilder text = new StringBuilder();
        while (scanner.hasNext()) {

            String next = scanner.nextLine();

            next = next.replaceAll("[,.!?]", "");

            text.append(next);
            if (scanner.hasNext()) {
                text.append(System.lineSeparator());
            }
        }

        for (int i = 0; i < text.length(); i++) {

            out.write(text.charAt(i));
        }

    }
}
