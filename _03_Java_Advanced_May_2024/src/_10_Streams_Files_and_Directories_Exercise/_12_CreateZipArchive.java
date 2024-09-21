package _10_Streams_Files_and_Directories_Exercise;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class _12_CreateZipArchive {
    public static void main(String[] args) throws IOException {


        File folder = new File("src/_10_Streams_Files_and_Directories_Exercise/Exercises Resources");

        File[] sourceFiles = folder.listFiles();

        String zippedFileName = "src/_10_Streams_Files_and_Directories_Exercise/ZIP_Test" + "/" + folder.getName() + ".zip";

        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zippedFileName));

        for (File sourceFile : sourceFiles) {

            FileInputStream fileInputStream = new FileInputStream(sourceFile);

            ZipEntry zipEntry = new ZipEntry(sourceFile.getName());
            zipOutputStream.putNextEntry(zipEntry);

            byte[] buffer = new byte[1024];
            int length;

            while ((length = fileInputStream.read(buffer)) >= 0) {

                zipOutputStream.write(buffer, 0, length);

            }
            zipOutputStream.closeEntry();
        }
        zipOutputStream.flush();
        System.out.println();

    }
}
