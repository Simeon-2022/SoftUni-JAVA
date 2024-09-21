package _10_Streams_Files_and_Directories_Exercise;

import java.io.*;

public class _02_SumBytes {
    public static void main(String[] args) throws IOException {

        String root = "src/_10_Streams_Files_and_Directories_Exercise/input.txt";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(root));
        int sum = 0;
        String line = bufferedReader.readLine();
        while (line != null) {

            for (char symbol : line.toCharArray()) {
                sum += symbol;
            }
            line = bufferedReader.readLine();
        }

        System.out.println(sum);

    }
}
