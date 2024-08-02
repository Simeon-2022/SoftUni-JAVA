package telephony;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> numbersInput = Arrays.asList(scanner.nextLine().split(" "));
        List<String> urlsInput = Arrays.asList(scanner.nextLine().split(" "));

/*
        String[] xxx = scanner.nextLine().split(" ");
        List.of(xxx);
*/

        Smartphone smartphone = new Smartphone(numbersInput,urlsInput);

        System.out.print(smartphone.call());
        System.out.print(smartphone.browse());

    }
}
