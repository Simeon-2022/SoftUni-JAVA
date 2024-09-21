package _09_Streams_Files_and_Directories_Lab;

import java.io.*;

public class _09_Serialize_Custom_Object {

    public static class Cube implements Serializable {

        String color;
        double width;
        double height;
        double depth;

        public Cube(String color, double width, double height, double depth) {
            this.color = color;
            this.width = width;
            this.height = height;
            this.depth = depth;
        }

        @Override
        public String toString() {
                return String.format("%s %.2f %.2f %.2f", color, width, height, depth);
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        String path = "D:\\Projects\\Git_projects\\JAVA\\SoftUni-JAVA\\_03_Java_Advanced_May_2024\\src\\_09_Streams_Files_and_Directories_Lab\\09.Serialize_Custom_Object.txt";

        Cube cube = new Cube("Green", 15.3, 12.4, 3.0);

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path));
        out.writeObject(cube);

        ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));

        Cube cube1 = (Cube)in.readObject();

        System.out.println(cube1);

    }
}
