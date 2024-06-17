package _07_Sets_And_Maps_Advanced_Lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class _02_SoftUni_Party {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        TreeSet<String> vip = new TreeSet<>();
        TreeSet<String> regular = new TreeSet<>();

        String input = scanner.nextLine();
        while (!"PARTY".equalsIgnoreCase(input)) {

            if (Character.isDigit(input.charAt(0))) {

                vip.add(input);
            } else {

                regular.add(input);
            }

            input = scanner.nextLine();
        }

        while (!"END".equalsIgnoreCase(input)) {

            if (Character.isDigit(input.charAt(0))) {

                vip.remove(input);
            } else {

                regular.remove(input);
            }

            input = scanner.nextLine();
        }

        System.out.println(vip.size() + regular.size());

        for (String v : vip) {
            System.out.println(v);
        }

        for (String r : regular) {
            System.out.println(r);
        }

    }
}
