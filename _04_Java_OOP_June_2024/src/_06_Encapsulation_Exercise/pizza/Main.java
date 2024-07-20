package _06_Encapsulation_Exercise.pizza;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        String[] inputPizza = scanner.nextLine().split(" ");
        String[] inputDough = scanner.nextLine().split(" ");

        Pizza pizza;
        Dough dough;

        try {
            pizza = new Pizza(inputPizza[1], Integer.parseInt(inputPizza[2]));
            dough = new Dough(inputDough[1], inputDough[2], Double.parseDouble(inputDough[3]));
            pizza.setDough(dough);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        String[] inputToppings = scanner.nextLine().split(" ");

        while (!inputToppings[0].equals("END")) {


            try {

                Topping topping = new Topping(inputToppings[1], Double.parseDouble(inputToppings[2]));

                pizza.addToppings(topping);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return;
            }
            inputToppings = scanner.nextLine().split(" ");
        }

        System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());
    }
}
