package _08_Sets_And_Maps_Advanced_Exercise;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class _03_Periodic_Table {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeSet<String> periodicTable = new TreeSet<>();

        for (int i = 0; i < 4; i++) {
            periodicTable.add(scanner.nextLine());
        }

        Iterator<String> iter = periodicTable.descendingIterator();
            while (iter.hasNext()) {
                System.out.println(iter.next());
            }


       // LinkedHashSet<String> reversed = new LinkedHashSet<>();
       // reversed.addAll(periodicTable.descendingSet());
       //LinkedHashSet<String> reversed = new LinkedHashSet<>(periodicTable.descendingSet());



    }
}
