package _13_Defining_Classes_Lab;

import java.util.Scanner;

public class Main_Car {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {

            String[] input = scanner.nextLine().split("\\s+");

            Car car;

            if (input.length == 3) {
                car = new Car(input[0], input[1], Integer.parseInt(input[2]));
            } else {
                car = new Car(input[0]);
            }

            System.out.println(car);


        }

    }
}
