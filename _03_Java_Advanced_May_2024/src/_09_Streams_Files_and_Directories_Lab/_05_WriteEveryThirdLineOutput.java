package _09_Streams_Files_and_Directories_Lab;

import java.io.*;

public class _05_WriteEveryThirdLineOutput {

    public static void main(String[] args) throws IOException {
        String readDir = "D:\\Projects\\Git_projects\\JAVA\\SoftUni-JAVA\\_03_Java_Advanced_May_2024\\src\\_09_Streams_Files_and_Directories_Lab\\input.txt";
        String writeDir = "D:\\Projects\\Git_projects\\JAVA\\SoftUni-JAVA\\_03_Java_Advanced_May_2024\\src\\_09_Streams_Files_and_Directories_Lab\\05.WriteEveryThirdLineOutput.txt";
    //    BufferedReader reader = new BufferedReader(new InputStreamReader( new FileInputStream(readDir)));

        BufferedReader readerIn = new BufferedReader(new FileReader(readDir));
        BufferedWriter readerOut = new BufferedWriter(new FileWriter(writeDir));

        int counter = 0;

        String line = readerIn.readLine();
        while (line != null) {


            if (++counter % 3 == 0) {
                line = line.concat("\n");
                readerOut.write(line);
            }

            line = readerIn.readLine();
        }

        readerIn.close();
        readerOut.close();
    }
}
