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

        collection.entrySet().removeIf(entry ->
                entry.getValue().contains(".com") || entry.getValue().contains(".uk") || entry.getValue().contains(".us"));

        /*   Iterator<Map.Entry<String, String>> iterator = collection.entrySet().iterator();
        while (iterator.hasNext()) {

            Map.Entry<String, String> entry = iterator.next();

            if (entry.getValue().contains(".com") || entry.getValue().contains(".uk") || entry.getValue().contains(".us")) {
                iterator.remove();
            }

        }*/

        collection.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}
