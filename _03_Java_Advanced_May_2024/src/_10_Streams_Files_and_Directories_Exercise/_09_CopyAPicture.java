package _10_Streams_Files_and_Directories_Exercise;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _09_CopyAPicture {
    public static void main(String[] args) throws IOException {

        String sourcePic = "src/_10_Streams_Files_and_Directories_Exercise/Exercises Resources/Screenshot_1.png";
        String targetPic = "src/_10_Streams_Files_and_Directories_Exercise/Exercises Resources/Screenshot_2.png";

        FileInputStream fileInputStream = new FileInputStream(sourcePic);
        FileOutputStream fileOutputStream = new FileOutputStream(targetPic);

        byte[] bytes = new byte[1024];

        int bytesRead;

        while ((bytesRead = fileInputStream.read(bytes)) != -1) {

            fileOutputStream.write(bytes,0,bytesRead);
        }

    }
}
