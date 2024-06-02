package _04_Stacks_And_Queues_Exercise;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Scanner;

public class _07_Simple_Text_Editor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder text = new StringBuilder();
        ArrayDeque<String> commands = new ArrayDeque<>();

        int operations = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < operations; i++) {

            String[] command = scanner.nextLine().split(" ");

            if (command[0].charAt(0) == '1') {
                commands.push(command[0] + " " + command[1]);
                text.append(command[1]);

            } else if (command[0].charAt(0) == '2') {
                int startIdx =text.length() - Integer.parseInt(command[1]);
                String strRemoved = text.substring(startIdx);
                commands.push(command[0] + " " + command[1] + " " + strRemoved);
                text.delete(startIdx, text.length());

            } else if (command[0].charAt(0) == '3') {
                int idx = Integer.parseInt(command[1]) - 1;
                System.out.println(text.charAt(idx));

            } else if (command[0].charAt(0) == '4') {

                String[] reversed = commands.pop().split(" ");

                switch (reversed[0]) {
                    case "2":
                        text.append(reversed[2]);
                        break;
                    case "1":
                        int removeLength = reversed[1].length();
                        text.delete(text.length() - removeLength, text.length());
                    break;
                }
            }
        }
    }
}
