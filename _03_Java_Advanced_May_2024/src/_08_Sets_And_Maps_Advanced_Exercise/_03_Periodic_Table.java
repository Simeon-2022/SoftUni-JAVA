package _08_Sets_And_Maps_Advanced_Exercise;

import java.util.*;

public class _03_Periodic_Table {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeSet<String> periodicTable = new TreeSet<>();

        int rounds = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < rounds; i++) {
            periodicTable.addAll(Arrays.stream(scanner.nextLine().split(" ")).toList());
        }

        //Iterator<String> iter = periodicTable.descendingIterator();
        Iterator<String> iter = periodicTable.iterator();

        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }


        // LinkedHashSet<String> reversed = new LinkedHashSet<>();
        // reversed.addAll(periodicTable.descendingSet());
        //LinkedHashSet<String> reversed = new LinkedHashSet<>(periodicTable.descendingSet());


    }
}
