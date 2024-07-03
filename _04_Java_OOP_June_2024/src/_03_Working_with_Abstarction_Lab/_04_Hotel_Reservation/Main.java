package _03_Working_with_Abstarction_Lab._04_Hotel_Reservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(" ");

        double pricePerDay = Double.parseDouble(tokens[0]);
        int numberOfDays = Integer.parseInt(tokens[1]);
        String season = tokens[2];
        String discount = tokens[3];

        Season seasonEnum = Season.valueOf(season.toUpperCase());
        DiscountType discountType = DiscountType.getType(tokens[3]);

        double cost = pricePerDay * numberOfDays * seasonEnum.getMultiplier() * discountType.getValue();

        System.out.println(String.format("%.2f",cost));
    }
}
