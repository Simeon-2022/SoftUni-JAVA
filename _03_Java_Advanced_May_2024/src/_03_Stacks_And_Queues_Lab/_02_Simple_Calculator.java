package _03_Stacks_And_Queues_Lab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class _02_Simple_Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strArr = scanner.nextLine().split(" ");

        ArrayDeque<String> str = fillArrayDeque(strArr);

        int result = 0;
        while (!str.isEmpty()) {

            String segment = str.pop();
            switch (segment) {
                case "+":
                    result += Integer.parseInt(str.pop());
                    break;
                case "-":
                    result -= Integer.parseInt(str.pop());
                    break;
                default:
                    result = Integer.parseInt(segment);
                    break;
            }
        }


      //  str.forEach(System.out::println);
        System.out.println(result);
    }

    public static ArrayDeque<String> fillArrayDeque(String[] str) {
        ArrayDeque<String> strToDeque = new ArrayDeque<>();

        Collections.addAll(strToDeque, str);

        return strToDeque;
    }

}
