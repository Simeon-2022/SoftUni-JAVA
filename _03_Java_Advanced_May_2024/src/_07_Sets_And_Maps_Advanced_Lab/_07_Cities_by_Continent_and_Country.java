package _07_Sets_And_Maps_Advanced_Lab;

import java.util.*;

public class _07_Cities_by_Continent_and_Country {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int iterations = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, LinkedHashMap<String, List<String>>> keyByContinent = new LinkedHashMap<>();

        for (int i = 0; i < iterations; i++) {

            String[] input = scanner.nextLine().split(" ");

            keyByContinent.putIfAbsent(input[0], new LinkedHashMap<>());

            LinkedHashMap<String, List<String>> keyByCountry = keyByContinent.get(input[0]);
            keyByCountry.putIfAbsent(input[1], new ArrayList<>());
            List<String> cities = keyByCountry.get(input[1]);
            cities.add(input[2]);
        }

        for (Map.Entry<String, LinkedHashMap<String, List<String>>> country : keyByContinent.entrySet()) {

            System.out.println(country.getKey() + ":");
            country.getValue().forEach((key, value) -> System.out.printf("  %s -> %s%n", key, String.join(", ", value)));
        }
    }
}
