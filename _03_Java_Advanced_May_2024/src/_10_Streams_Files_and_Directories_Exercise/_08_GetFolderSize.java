package _10_Streams_Files_and_Directories_Exercise;

import java.io.File;

public class _08_GetFolderSize {

    public static void main(String[] args) {
        String folderPath = "src/_10_Streams_Files_and_Directories_Exercise/Exercises Resources";

        File folder = new File(folderPath);

        int totalSize = 0;

        File[] files = folder.listFiles();

        for (File file : files) {
            totalSize += file.length();
        }

        System.out.println("Folder size: " + totalSize);


    }
}
