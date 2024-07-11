package _06_Encapsulation_Exercise.classBox;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        double length = Double.parseDouble(scanner.nextLine());
        double width = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());

        Box box = null;
        try {
            box = new Box(length, width, height);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        if (box != null) {
            System.out.println(box);
        }

    }
}
