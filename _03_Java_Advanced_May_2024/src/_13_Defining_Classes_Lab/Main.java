package _13_Defining_Classes_Lab;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {

            String[] input = scanner.nextLine().split("\\s+");

            Car car = new Car();

            car.setBrand(input[0]);
            car.setModel(input[1]);
            car.setHorsePower(Integer.parseInt(input[2]));

            System.out.println(car);

        }

    }
}
