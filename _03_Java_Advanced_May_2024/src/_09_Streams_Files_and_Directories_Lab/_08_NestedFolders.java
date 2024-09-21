package _09_Streams_Files_and_Directories_Lab;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Arrays;

public class _08_NestedFolders {
    public static void main(String[] args) {

        String rootDir = "D:\\Projects\\Git_projects\\JAVA\\SoftUni-JAVA\\_03_Java_Advanced_May_2024\\src\\_09_Streams_Files_and_Directories_Lab\\Files-and-Streams";

        File root = new File(rootDir);
        File[] files = root.listFiles();

        ArrayDeque<File[]> dirs = new ArrayDeque<>();
        dirs.add(files);
        System.out.println(root.getName());
        int countTotal = 1;

        while (!dirs.isEmpty()) {

            for (File file : dirs.pollFirst()) {

                if (file.isDirectory()) {
                    System.out.println(file.getName());
                   countTotal++;

                    root = new File(file.getAbsolutePath());
                    files = root.listFiles();
                    long count = Arrays.stream(files).count();
                    if (count > 0) {
                        dirs.add(files);
                    }
                }
            }
        }

        System.out.println(countTotal + " folders");
    }
}
