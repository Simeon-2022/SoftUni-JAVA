package _05_Conditional_Statements_and_Loops_Lab;

import java.util.Scanner;

public class _01_Student_Information {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        double grade = Double.parseDouble(scanner.nextLine());
        System.out.printf("Name: %s, Age: %d, Grade: %.2f", name,age,grade);

    }
}
