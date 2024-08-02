package wildFarm;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("End")) {

            String[] animalInfo = input.split(" ");

            Animal animal = null;
            Food food;
            // {AnimalType} {AnimalName} {AnimalWeight} {AnimalLivingRegion}

            String type = animalInfo[0];
            String name = animalInfo[1];
            Double weight = Double.parseDouble(animalInfo[2]);
            String livingRegion = animalInfo[3];

            switch (type) {
                case "Cat":
                    // {AnimalType} {AnimalName} {AnimalWeight} {AnimalLivingRegion} {CatBreed}
                    String catBreed = animalInfo[4];
                    animal = new Cat(type, name, weight, livingRegion, catBreed);
                    break;

                case "Tiger":
                    animal = new Tiger(type, name, weight, livingRegion);
                    break;

                case "Mouse":
                    animal = new Mouse( type, name, weight, livingRegion);
                    break;

                case "Zebra":
                    animal = new Zebra(type, name, weight, livingRegion);
                    break;
            }


            animal.makeSound();

            food = getFoodType(scanner);
            try {
                animal.eat(food);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println(animal);

            input = scanner.nextLine();
        }
    }

    private static Food getFoodType(Scanner scanner) {

        String[] foodInfo = scanner.nextLine().split(" ");
        String foodType = foodInfo[0];
        Food food;

        if (foodType.equals("Vegetable")) {
            food = new Vegetable(Integer.parseInt(foodInfo[1]));
        } else {
            food = new Meat(Integer.parseInt(foodInfo[1]));
        }

        return food;
    }

}
