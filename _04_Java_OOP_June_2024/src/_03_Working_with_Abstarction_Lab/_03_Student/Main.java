package _03_Working_with_Abstarction_Lab._03_Student;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StudentSystem studentSystem = new StudentSystem();
        String command = scanner.nextLine();

        while (!command.equals("Exit")) {

            studentSystem.parseCommand(command);

            command = scanner.nextLine();
        }
    }
}
