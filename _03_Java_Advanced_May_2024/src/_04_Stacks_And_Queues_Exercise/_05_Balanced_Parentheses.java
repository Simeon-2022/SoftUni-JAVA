package _04_Stacks_And_Queues_Exercise;

import java.util.*;

public class _05_Balanced_Parentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Character> openingParenthesis = new ArrayDeque<>();

        if (input.length() % 2 != 0 || input.isEmpty()) {
            System.out.println("NO");
            return;
        }

        for (int i = 0; i < input.length(); i++) {

            char par = input.charAt(i);
            if (par == '{' || par == '[' || par == '(') {
                openingParenthesis.offerFirst(par);

            } else if (openingParenthesis.isEmpty() || !isMatch(openingParenthesis.pop(), par)) {

                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }

    public static boolean isMatch(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }
}

