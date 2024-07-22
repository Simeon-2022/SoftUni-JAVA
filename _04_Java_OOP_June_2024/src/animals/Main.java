package animals;

import java.util.Scanner;

public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);


    public static void main(String[] args) throws IllegalArgumentException {

        String command = SCANNER.nextLine();

        while (!command.equalsIgnoreCase("Beast!")) {

            String type = command;

            Animal animal = createAnimal(type);

            if (animal != null) {
                System.out.println(animal);
            }

            command = SCANNER.nextLine();
        }
    }

    private static Animal createAnimal(String type) {

        Animal animal = null;
        String[] FEATURES = SCANNER.nextLine().split(" ");

        String name = FEATURES[0];
        int age = Integer.parseInt(FEATURES[1]);
        String gender = FEATURES[2];

        try {

            switch (type) {
                case "Cat":
                    animal = new Cat(name, age, gender);
                    break;
                case "Dog":
                    animal = new Dog(name, age, gender);
                    break;
                case "Frog":
                    animal = new Frog(name, age, gender);
                    break;
                case "Kitten":
                    animal = new Kitten(name, age);
                    break;
                case "Tomcat":
                    animal = new Tomcat(name, age);
                    break;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return animal;
    }

}
