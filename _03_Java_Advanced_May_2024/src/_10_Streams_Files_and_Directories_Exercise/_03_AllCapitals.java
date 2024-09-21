package _10_Streams_Files_and_Directories_Exercise;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class _03_AllCapitals {
    public static void main(String[] args) throws IOException {

        String destination = "src/_10_Streams_Files_and_Directories_Exercise/output.txt";
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(destination));

        String root = "src/_10_Streams_Files_and_Directories_Exercise/input.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(root));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(destination));

/*        String line = bufferedReader.readLine();
        while (line != null) {

            printWriter.println(line.toUpperCase());
            printWriter.flush();
            line = bufferedReader.readLine();
        }*/

        String content = Files.readString(Path.of(root));
        bufferedWriter.write(content.toUpperCase());
        bufferedWriter.close();
    }
}
