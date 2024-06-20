package _08_Sets_And_Maps_Advanced_Exercise;

import java.util.HashMap;
import java.util.Scanner;

public class _05_Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, String> phoneBook = new HashMap<>();

        String command = scanner.nextLine();

        while (!"search".equalsIgnoreCase(command)) {

            String name = command.substring(0, command.indexOf('-'));
            String number = command.substring(command.indexOf('-') + 1);
            phoneBook.put(name, number);

            command = scanner.nextLine();
        }

        String name = scanner.nextLine();
        while (!"stop".equalsIgnoreCase(name)) {

            if (phoneBook.containsKey(name)) {
                System.out.println(name + " -> " + phoneBook.get(name));
            } else {
                System.out.println("Contact " + name + " does not exist.");
            }

            name = scanner.nextLine();

        }

    }
}
