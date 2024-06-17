package _07_Sets_And_Maps_Advanced_Lab;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class _01_Parking_Lot {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        LinkedHashSet<String> parking = new LinkedHashSet<>();

        while (!"END".equalsIgnoreCase(input)) {
            String direction = input.substring(0, input.indexOf(','));
            String licencePlate = input.substring(input.indexOf('C'));

            if (direction.equals("IN")) {
                parking.add(licencePlate);
            } else {
                parking.remove(licencePlate);
            }

            if (parking.isEmpty()) {
                System.out.println("Parking Lot is Empty");
                return;
            }

            input = scanner.nextLine();
        }

        for (String car : parking) {
            System.out.println(car);
        }
    }

}
