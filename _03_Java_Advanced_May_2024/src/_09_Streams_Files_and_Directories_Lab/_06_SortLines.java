package _09_Streams_Files_and_Directories_Lab;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.UserPrincipal;
import java.util.List;

public class _06_SortLines {
    public static void main(String[] args) throws IOException {

        String readDir = "D:\\Projects\\Git_projects\\JAVA\\SoftUni-JAVA\\_03_Java_Advanced_May_2024\\src\\_09_Streams_Files_and_Directories_Lab\\input.txt";
        String writeDir = "D:\\Projects\\Git_projects\\JAVA\\SoftUni-JAVA\\_03_Java_Advanced_May_2024\\src\\_09_Streams_Files_and_Directories_Lab\\06.SortLinesOutput.txt";

        Path pathIn = Paths.get(readDir);
        Path pathOut = Paths.get(writeDir);

        List<String> lines = Files.readAllLines(pathIn).stream().filter(l->!l.isBlank()).sorted().toList();
        //List<String> lines = Files.readAllLines(pathIn).stream().sorted().toList();

        //UserPrincipal owner = Files.getOwner(pathOut);
        //System.out.println(owner);
        Files.write(pathOut, lines);

        File file = new File(writeDir);

    }
}
