package _14_Defining_Classes_Exercise._01_Opinion_Poll;

import java.util.*;

public class Main_Opinion_Poll {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Person> ppl = new ArrayList<>();

        while (n-- > 0) {

            String input = scanner.nextLine();
            String name = input.substring(0, input.indexOf(' '));
            int age = Integer.parseInt(input.substring(input.indexOf(' ') + 1));

            ppl.add(new Person(name, age));
        }

        ppl.stream()
                .sorted(Comparator.comparing(Person::getName))
                .filter(p -> p.getAge() > 30)
                .forEach(p -> System.out.println(p.getName() + " - " + p.getAge()));
    }
}
