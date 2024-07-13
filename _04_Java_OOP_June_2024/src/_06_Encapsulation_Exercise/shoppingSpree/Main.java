package _06_Encapsulation_Exercise.shoppingSpree;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String[] peopleAndMoney = scanner.nextLine().split(";");
        String[] productsAndPrice = scanner.nextLine().split(";");

        List<Person> people;
        List<Product> product;

        try {
            people = initPersonList(peopleAndMoney);
            product = initProductList(productsAndPrice);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }


        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] personAndProduct = input.split(" ");
            String name = personAndProduct[0];
            String productName = personAndProduct[1];

            Person currentPerson = people.get(people.stream().map(Person::getName).toList().indexOf(name));
            Product currentproduct = product.get(product.stream().map(Product::getName).toList().indexOf(productName));
            try {

                currentPerson.buyProduct(currentproduct);
            } catch (Exception e) {

                System.out.println(e.getMessage());
            }
            input = scanner.nextLine();
        }

        for (Person person : people) {

            if (person.getProducts().isEmpty()) {
                System.out.println(person.getName() + " - Nothing bought");
            } else {
                String basket = person.getProducts().stream().map(Product::getName).collect(Collectors.joining(", "));
                System.out.printf("%s - %s%n", person.getName(), basket);
            }

        }

    }

    private static List<Person> initPersonList(String[] arr) {
        List<Person> people = new ArrayList<>();

        for (String str : arr) {
            people.add(new Person(str.split("=")[0], Integer.parseInt(str.split("=")[1])));
        }
        return people;
    }

    private static List<Product> initProductList(String[] arr) {
        List<Product> product = new ArrayList<>();

        for (String str : arr) {
            product.add(new Product(str.split("=")[0], Double.parseDouble(str.split("=")[1])));
        }
        return product;
    }

}
