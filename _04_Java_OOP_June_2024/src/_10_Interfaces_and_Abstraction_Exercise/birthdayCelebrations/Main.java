package birthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Birthable> birthables = new ArrayList<>();

        String command = scanner.nextLine();
        while (!command.equals("End")) {

            String[] data = command.split(" ");

            String name = data[1];
            String date = data[data.length - 1];

            switch (data[0]) {

                case "Citizen":
                    int age = Integer.parseInt(data[2]);
                    String id = data[3];
                    birthables.add(new Citizen(name, age, id, date));
                    break;

                case "Pet":
                    birthables.add(new Pet(name, date));
                    break;
            }

            command = scanner.nextLine();
        }

        String year = scanner.nextLine();

        long count = birthables.stream().map(Birthable::getBirthDate).filter(e -> e.endsWith(year)).count();

        if (count == 0) {
            System.out.println("<no output>");
        } else {
            birthables.stream().map(Birthable::getBirthDate).filter(e -> e.endsWith(year)).forEach(System.out::println);
        }

    }
}