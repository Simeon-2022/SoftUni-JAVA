package _03_Stacks_And_Queues_Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _05_Printer_Queue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        ArrayDeque<String> queuePrint = new ArrayDeque<>();

        while (!command.equals("print")) {

            if (command.equals("cancel")) {

                if (!queuePrint.isEmpty()) {
                    System.out.println("Canceled " + queuePrint.removeLast());
                } else {
                    System.out.println("Printer is on standby");
                }
            } else {
                queuePrint.offerFirst(command);
            }


            command = scanner.nextLine();
        }
        printStack(queuePrint);
    }
    public static void printStack(ArrayDeque<String> stack) {

        while (!stack.isEmpty()) {
            System.out.println(stack.pollLast());
        }
    }
}
