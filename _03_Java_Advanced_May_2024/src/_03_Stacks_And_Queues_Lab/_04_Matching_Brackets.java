package _03_Stacks_And_Queues_Lab;

import javax.management.StringValueExp;
import java.util.ArrayDeque;
import java.util.Scanner;

public class _04_Matching_Brackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String expression = scanner.nextLine(); //"(2 + 3) - (2 + 3)";// "1 + (2 - (2 + 3) * 4 / (3 + 1)) * 5";
        ArrayDeque<Integer> indexStack = new ArrayDeque<>();

        for (int i = 0; i < expression.length(); i++) {
            int startIndex = -1;
            if (expression.charAt(i) == '(') {
                indexStack.push(i);
            } else if (expression.charAt(i) == ')') {
                startIndex = indexStack.pop();
                System.out.println(expression.subSequence(startIndex, i + 1));
            }

        }





     /*    for (int i = 0; i < expression.length(); i++) {
            if ('(' == expression.charAt(i)) {

                subExpresion.add(String.valueOf(expression.charAt(i)));

                int countClose = 1;
                int countOpen = 0;
                for (int j = i + 1; j < expression.length(); j++) {
                    if (expression.charAt(j) == '(') {
                        countClose++;

                    } else if (expression.charAt(j) == ')') {
                        countOpen++;
                    }
                    subExpresion.add(String.valueOf(expression.charAt(j)));

                    if (countClose == countOpen) {
                        printStack(subExpresion);
                        System.out.println();
                        break;
                    }
                }
            }
        }
*/
    }

    public static void printStack(ArrayDeque<String> stack) {

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}