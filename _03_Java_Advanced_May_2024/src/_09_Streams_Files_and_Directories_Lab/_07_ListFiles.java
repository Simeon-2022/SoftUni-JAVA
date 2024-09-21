package _09_Streams_Files_and_Directories_Lab;

import java.io.File;

public class _07_ListFiles {
    public static void main(String[] args) {


        String dir = "D:\\Projects\\Git_projects\\JAVA\\SoftUni-JAVA\\_03_Java_Advanced_May_2024\\src\\_09_Streams_Files_and_Directories_Lab\\Files-and-Streams";

        File file = new File(dir);

        if (file.exists()) {

            File[] files = file.listFiles();

            for (File f : files) {

                if (f.isFile()) {
                    System.out.println(f.getName() + ": [" + f.length() + "]");
                }
            }
        }
    }
}
