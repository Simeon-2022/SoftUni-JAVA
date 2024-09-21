package _09_Streams_Files_and_Directories_Lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class _01_ReadFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String path = "D:\\Projects\\Git_projects\\JAVA\\SoftUni-JAVA\\_03_Java_Advanced_May_2024\\src\\_09_Streams_Files_and_Directories_Lab\\input.txt";


        try (FileInputStream fileInputStream = new FileInputStream(path)) {
            System.out.println("File opened!");

            int asciiCode = fileInputStream.read();

            while (asciiCode != -1) {

               // System.out.print(Integer.toBinaryString(asciiCode) + " ");
                System.out.print(asciiCode);

                asciiCode = fileInputStream.read();
            }


        } catch (IOException e) {
            System.err.println("No file found: " + path);;
        }






    }
}
