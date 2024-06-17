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
            String direction = input.substring(0, input.indexOf(","));
            String licencePlate = input.substring(input.indexOf(" ")).trim();

            if (direction.equals("IN")) {
                parking.add(licencePlate);
            } else if (direction.equals("OUT")) {
                parking.remove(licencePlate);

            }
            input = scanner.nextLine();
        }

        String result = parking.isEmpty()
                ?"Parking Lot is Empty"
                :String.join(System.lineSeparator(),parking);

        System.out.println(result);
    }

}
