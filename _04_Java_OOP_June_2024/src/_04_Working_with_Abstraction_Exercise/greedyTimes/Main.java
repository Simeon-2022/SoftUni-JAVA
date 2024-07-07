
package _04_Working_with_Abstraction_Exercise.greedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        long capacity = Long.parseLong(scanner.nextLine());
        String[] safe = scanner.nextLine().split("\\s+");

        LinkedHashMap<String, LinkedHashMap<String, Long>> treasureBag = new LinkedHashMap<>();

        for (int i = 0; i < safe.length; i += 2) {

            String name = safe[i];
            long countOfItem = Long.parseLong(safe[i + 1]);
            String type = getTreasureType(name);

            if (type.isEmpty() || capacity < getTreasuryTotalValue(treasureBag) + countOfItem || checkForExceededCapacity(treasureBag, type, countOfItem)) {
                continue;
            }

            treasureBag.putIfAbsent(type, new LinkedHashMap<>());
            treasureBag.get(type).putIfAbsent(name, 0L);

            treasureBag.get(type).put(name, treasureBag.get(type).get(name) + countOfItem);

        }
        printResult(treasureBag);
    }

    private static void printResult(LinkedHashMap<String, LinkedHashMap<String, Long>> treasureBag) {

        for (var x : treasureBag.entrySet()) {
            Long sumValues = x.getValue().values().stream().mapToLong(l -> l).sum();

            System.out.println(String.format("<%s> $%s", x.getKey(), sumValues));

            x.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));

        }
    }

    private static boolean checkForExceededCapacity(LinkedHashMap<String, LinkedHashMap<String, Long>> treasureBag, String type, long countOfItem) {
        switch (type) {
            case "Gem":
                if (!treasureBag.containsKey(type)) {
                    if (treasureBag.containsKey("Gold")) {
                        if (countOfItem > getTypeValue(treasureBag, "Gold")) {
                            return true;
                        }
                    } else {
                        return true;
                    }
                } else if (getTypeValue(treasureBag, type) + countOfItem > getTypeValue(treasureBag, "Gold")) {
                    return true;
                }
                break;
            case "Cash":
                if (!treasureBag.containsKey(type)) {
                    if (treasureBag.containsKey("Gem")) {
                        if (countOfItem > getTypeValue(treasureBag, "Gem")) {
                            return true;
                        }
                    } else {
                        return true;
                    }
                } else if (getTypeValue(treasureBag, type) + countOfItem > getTypeValue(treasureBag, "Gem")) {
                    return true;
                }
                break;
        }
        return false;
    }

    private static String getTreasureType(String name) {
        String type = "";
        if (name.length() == 3) {
            type = "Cash";
        } else if (name.toLowerCase().endsWith("gem")) {
            type = "Gem";
        } else if (name.equalsIgnoreCase("gold")) {
            type = "Gold";
        }
        return type;
    }

    private static long getTreasuryTotalValue(LinkedHashMap<String, LinkedHashMap<String, Long>> treasureBag) {
        return treasureBag.values().stream().map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum();
    }

    private static long getTypeValue(LinkedHashMap<String, LinkedHashMap<String, Long>> treasureBag, String type) {
        return treasureBag.get(type).values().stream().mapToLong(e -> e).sum();
    }


}