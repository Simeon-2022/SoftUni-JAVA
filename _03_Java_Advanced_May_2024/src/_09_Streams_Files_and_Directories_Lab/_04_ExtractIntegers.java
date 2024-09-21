package _09_Streams_Files_and_Directories_Lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class _04_ExtractIntegers {

    public static void main(String[] args) throws FileNotFoundException {


        String path = "D:\\Projects\\Git_projects\\JAVA\\SoftUni-JAVA\\_03_Java_Advanced_May_2024\\src\\_09_Streams_Files_and_Directories_Lab\\input.txt";
        String out = "D:\\Projects\\Git_projects\\JAVA\\SoftUni-JAVA\\_03_Java_Advanced_May_2024\\src\\_09_Streams_Files_and_Directories_Lab\\04.ExtractIntegersOutput.txt";

        Scanner scanner = new Scanner(new FileInputStream (path));

        PrintWriter writer = new PrintWriter(new FileOutputStream(out));

        while (scanner.hasNext()) {

            scanner.next();

            if (scanner.hasNextInt()) {

                writer.println(scanner.nextInt());

            }
        }
        writer.close();
    }
}
