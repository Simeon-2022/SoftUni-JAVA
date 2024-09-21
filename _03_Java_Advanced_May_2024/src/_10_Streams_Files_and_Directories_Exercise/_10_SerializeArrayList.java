package _10_Streams_Files_and_Directories_Exercise;

import java.io.*;
import java.util.ArrayList;

public class _10_SerializeArrayList {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ArrayList<Double> list = new ArrayList<>();
        list.add(1.1);
        list.add(2.2);
        list.add(3.3);
        list.add(4.4);
        list.add(5.5);
        System.out.println(list);

        String source = "src/_10_Streams_Files_and_Directories_Exercise/Exercises Resources/list.ser";
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(source));
        objectOutputStream.writeObject(list);

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(source));
        ArrayList<Double> list1 = (ArrayList<Double>)objectInputStream.readObject();
        System.out.println(list1);

    }
}
