package _10_Streams_Files_and_Directories_Exercise;

import java.io.*;

public class _11_SerializeCustomObject {

    private static class Course implements Serializable {
        String name;
        int numberOfStudents;

        public Course(String name, int numberOfStudents) {
            this.name = name;
            this.numberOfStudents = numberOfStudents;
        }

        @Override
        public String toString() {
            return String.format("%s -> %d",name,numberOfStudents);
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        String path = "src/_10_Streams_Files_and_Directories_Exercise/Exercises Resources/Output.txt";

        Course course = new Course("Biology", 100);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));

        objectOutputStream.writeObject(course);

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
        Course courseCopy = (Course)objectInputStream.readObject();

        System.out.println(courseCopy);

    }
}
