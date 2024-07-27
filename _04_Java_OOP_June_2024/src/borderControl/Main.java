package borderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Identifiable> ids = new ArrayList<>();

        String command = scanner.nextLine();

        while (!command.equals("End")) {

            String[] data = command.split(" ");

            String name = data[0];
            String id = data[data.length - 1];

            if (data.length > 2) {
                int age = Integer.parseInt(data[1]);
                ids.add(new Citizen(name, age, id));

            } else {
                ids.add(new Robot(name,id));
            }

            command = scanner.nextLine();
        }

        String sample = scanner.nextLine();

       /* for (Identifiable id : ids) {
            if (id.getId().endsWith(sample)) {
                System.out.println(id.getId());
            }
        }*/

        ids.stream().map(Identifiable::getId).filter(id->id.endsWith(sample)).forEach(System.out::println);


    }
}
