package _07_Sets_And_Maps_Advanced_Lab;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class _06_Product_Shop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, LinkedHashMap<String, Double>> shopList = new TreeMap<>();
        DecimalFormat df = new DecimalFormat("#.0");

        String command = scanner.nextLine();

        while (!"Revision".equalsIgnoreCase(command)) {

            String[] input = command.split(", ");
            shopList.putIfAbsent(input[0], new LinkedHashMap<>());

            Map<String, Double> productAndPrice = shopList.get(input[0]);
            productAndPrice.put(input[1], Double.parseDouble(input[2]));

            command = scanner.nextLine();
        }


        for (Map.Entry<String, LinkedHashMap<String, Double>> shop : shopList.entrySet()) {

            System.out.println(shop.getKey() + "->");
            shop.getValue().forEach((key, value) -> System.out.printf("Product: %s, Price: %.1f%n", key, value));

        }
    }
}
