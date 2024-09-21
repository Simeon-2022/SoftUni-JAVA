package _09_Streams_Files_and_Directories_Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _03_CopyBytes {
    public static void main(String[] args) throws IOException {


        String path = "D:\\Projects\\Git_projects\\JAVA\\SoftUni-JAVA\\_03_Java_Advanced_May_2024\\src\\_09_Streams_Files_and_Directories_Lab\\input.txt";
        String pathTo = "D:\\Projects\\Git_projects\\JAVA\\SoftUni-JAVA\\_03_Java_Advanced_May_2024\\src\\_09_Streams_Files_and_Directories_Lab\\03.CopyBytesOutput.txt";

        FileInputStream in = new FileInputStream(path);
        FileOutputStream out = new FileOutputStream(pathTo);

        int asciiCode = in.read();
        while (asciiCode != -1) {

            String asciiToString;

            if (asciiCode == 32 || asciiCode == 10) {
                asciiToString = String.valueOf((char)asciiCode);

            } else {
                asciiToString = String.valueOf(asciiCode);

            }

            for (int i = 0; i < asciiToString.length(); i++) {

                out.write(asciiToString.charAt(i));
            }
            asciiCode = in.read();
        }
    }
}