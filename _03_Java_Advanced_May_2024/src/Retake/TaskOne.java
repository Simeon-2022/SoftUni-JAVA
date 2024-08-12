package Retake;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class TaskOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> seqBeeGroupsDefenders = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toList();
        List<Integer> seqBeeEatersAttackers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toList();

        ArrayDeque<Integer> defenders = new ArrayDeque<>(seqBeeGroupsDefenders);
        ArrayDeque<Integer> attackers = new ArrayDeque<>(seqBeeEatersAttackers);

        while (!defenders.isEmpty() && !attackers.isEmpty()) {

            int defenderGroup = defenders.getFirst();

            int attackerGroup = attackers.getLast();

            while (defenderGroup > 0) {

                defenderGroup -= 7;
                if (defenderGroup >= 0) {

                    attackerGroup -= 1;

                    if (attackerGroup == 0) {
                        break;
                    }
                }
            }

            if (defenderGroup <= 0) {
                defenders.removeFirst();
            } else {
                defenders.removeFirst();
                defenders.offerLast(defenderGroup);
            }


            if (attackerGroup <= 0) {
                attackers.removeLast();
            } else {
                attackers.removeLast();
                attackers.offerLast(attackerGroup);
            }

        }



        System.out.println("The final battle is over!");
        if (defenders.isEmpty() && attackers.isEmpty()) {
            System.out.println("But no one made it out alive!");
        } else if (!defenders.isEmpty()) {
            System.out.printf("Bee groups left: %s", Arrays.toString(defenders.toArray()).replaceAll("[\\[\\]]",""));

        } else if (!attackers.isEmpty()) {

            System.out.printf("Bee-eater groups left: %s", Arrays.toString(attackers.toArray()).replaceAll("[\\[\\]]",""));
        }
    }
}
