package _06_Multidimensional_Arrays_Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _08_The_Heigan_Dance {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = new int[15][15];
        fillmatrix(matrix);

        int playerStartRow = 15 / 2;
        int playerStartCol = 15 / 2;

        double heiganHealthPoints = 3000000;
        int playerHealthPoints = 18500;

        int plagueCloudDamage = 3500;
        int eruptionDamage = 6000;
        String lastHitBy = "";

        double damageToHeigan = Double.parseDouble(scanner.nextLine());
        boolean isCloudActive = false;

        while (heiganHealthPoints > 0 && playerHealthPoints > 0) {


            String input = scanner.nextLine();
            String spell = input.split(" ")[0];

            List<Integer> damagedArea = getIntegers(input, matrix);

            boolean moveUp = false;
            boolean moveLeft = false;
            boolean moveDown = false;
            boolean moveRight = false;

            heiganHealthPoints -= damageToHeigan;

            if (isCloudActive) {
                playerHealthPoints -= plagueCloudDamage;
                lastHitBy = "Plague Cloud";
                isCloudActive = false;
            }

            if (heiganHealthPoints > 0 && playerHealthPoints > 0) {

                if (damagedArea.contains(matrix[playerStartRow][playerStartCol])) {


                    if (isInsideMatrix(matrix, playerStartRow - 1, playerStartCol) && !damagedArea.contains(matrix[playerStartRow - 1][playerStartCol])) {
                        moveUp = true;
                        --playerStartRow;

                    }else if (isInsideMatrix(matrix, playerStartRow, playerStartCol + 1) && !damagedArea.contains(matrix[playerStartRow][playerStartCol + 1])) {
                        moveRight = true;
                        ++playerStartCol;

                    } else if (isInsideMatrix(matrix, playerStartRow + 1, playerStartCol) && !damagedArea.contains(matrix[playerStartRow + 1][playerStartCol])) {
                        moveDown = true;
                        ++playerStartRow;

                    } else if (isInsideMatrix(matrix, playerStartRow, playerStartCol - 1) && !damagedArea.contains(matrix[playerStartRow][playerStartCol - 1])) {
                        moveLeft = true;
                        --playerStartCol;

                    }

                    if (!moveUp && !moveLeft && !moveDown && !moveRight) {

                        if (spell.equals("Cloud")) {

                            playerHealthPoints -= plagueCloudDamage;
                            isCloudActive = true;
                            lastHitBy = "Plague Cloud";

                        } else {
                            playerHealthPoints -= eruptionDamage;
                            lastHitBy = "Eruption";
                        }
                    }
                }
            }
        }

        if (heiganHealthPoints <= 0) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("%s: %.2f%n", "Heigan", heiganHealthPoints);
        }

        if (playerHealthPoints <= 0) {

            System.out.println("Player: Killed by " + lastHitBy);
        } else {
            System.out.printf("Player: %d%n", playerHealthPoints);
        }

        System.out.printf("Final position: %d, %d", playerStartRow, playerStartCol);

    }

    private static List<Integer> getIntegers(String input, int[][] matrix) {
        int affectedRow = Integer.parseInt(input.split(" ")[1]);
        int affectedCol = Integer.parseInt(input.split(" ")[2]);

        int subRowStart = Math.max(0, affectedRow - 1);
        int subColStart = Math.max(0, affectedCol - 1);
        int subRowEnd = Math.min(affectedRow + 1, 14);
        int subColEnd = Math.min(affectedCol + 1, 14);

        List<Integer> damagedArea = new ArrayList<>();
        for (int row = subRowStart; row <= subRowEnd; row++) {
            for (int col = subColStart; col <= subColEnd; col++) {
                damagedArea.add(matrix[row][col]);
            }
        }
        return damagedArea;
    }

    private static boolean isInsideMatrix(int[][] matrix, int playerRow, int playerCol) {
        return playerRow >= 0 && playerRow < matrix.length && playerCol >= 0 && playerCol < matrix[matrix.length - 1].length;
    }

    private static void fillmatrix(int[][] matrix) {
        int counter = 1;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = counter++;
            }
        }
    }
}
