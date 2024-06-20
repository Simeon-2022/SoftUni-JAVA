package _08_Sets_And_Maps_Advanced_Exercise;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class _06_Fix_Emails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, String> collection = new LinkedHashMap<>();

        String name = scanner.nextLine();
        while (!"stop".equalsIgnoreCase(name)) {
            String email = scanner.nextLine();

            collection.put(name, email);

            name = scanner.nextLine();
        }


        collection.forEach((key, value) -> {
            if (value.contains(".com") || value.contains(".uk") || value.contains(".us")) {
                collection.remove(key);
            }
        });

        collection.forEach((key, value) -> System.out.println(key +" -> " + value));
    }
}
