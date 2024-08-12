package _24_Regular_Exam;

import java.util.Scanner;

public class _02_ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[][] field = new String[n][];

        int beeRow = 0;
        int beeCol = 0;
        for (int i = 0; i < n; i++) {

            String currentRow = scanner.nextLine();
            field[i] = currentRow.split("");

            if (currentRow.indexOf('B') != -1) {
                beeCol = currentRow.indexOf('B');
                beeRow = i;
                field[beeRow][beeCol] = "-";
            }
        }

        int beeEnergyUnits = 15;
        int totalCollectedNectar = 0;
        int restorationAttempts = 0;
        boolean isHiveReached = false;


        while (beeEnergyUnits > 0) {

            String direction = scanner.nextLine();  //"up", "down", "left", and "right"
            int currentRoundEnergyCollected = 0;

            switch (direction) {
                case "up":
                    beeEnergyUnits--;
                    beeRow = moveUp(n, beeRow);

                    if (Character.isDigit(field[beeRow][beeCol].charAt(0))) {
                        currentRoundEnergyCollected += Integer.parseInt(field[beeRow][beeCol]);
                        field[beeRow][beeCol] = "-";

                    } else if (field[beeRow][beeCol].charAt(0) == 'H') {
                        isHiveReached = true;
                    }

                    break;

                case "down":
                    beeEnergyUnits--;
                    beeRow = moveDown(n, beeRow);

                    if (Character.isDigit(field[beeRow][beeCol].charAt(0))) {
                        currentRoundEnergyCollected += Integer.parseInt(field[beeRow][beeCol]);
                        field[beeRow][beeCol] = "-";

                    } else if (field[beeRow][beeCol].charAt(0) == 'H') {
                        isHiveReached = true;
                    }

                    break;

                case "left":
                    beeEnergyUnits--;
                    beeCol = moveLeft(n, beeCol);

                    if (Character.isDigit(field[beeRow][beeCol].charAt(0))) {
                        currentRoundEnergyCollected += Integer.parseInt(field[beeRow][beeCol]);
                        field[beeRow][beeCol] = "-";

                    } else if (field[beeRow][beeCol].charAt(0) == 'H') {
                        isHiveReached = true;
                    }

                    break;

                case "right":
                    beeEnergyUnits--;
                    beeCol = moveRight(n, beeCol);

                    if (Character.isDigit(field[beeRow][beeCol].charAt(0))) {
                        currentRoundEnergyCollected += Integer.parseInt(field[beeRow][beeCol]);
                        field[beeRow][beeCol] = "-";

                    } else if (field[beeRow][beeCol].charAt(0) == 'H') {
                        isHiveReached = true;
                    }
                    break;
            }



            totalCollectedNectar += currentRoundEnergyCollected;
            if (isHiveReached || (beeEnergyUnits <= 0 && totalCollectedNectar < 30) ) {
                //TODO: The correct output should be printed on the Console. -Done
                break;

            } else if (beeEnergyUnits <= 0 && totalCollectedNectar >= 30) {

                if (++restorationAttempts > 1) {
                    break;
                }

                beeEnergyUnits += totalCollectedNectar - 30;
                totalCollectedNectar = 30;

                //TODO Hint: Check for zero energy after restoration. -Done


            }
        }

        if (isHiveReached && totalCollectedNectar >= 30) {
            System.out.printf("Great job, Beesy! The hive is full. Energy left: %d%n", beeEnergyUnits);

        } else if (isHiveReached ) { //&& totalCollectedNectar < 30
            System.out.println("Beesy did not manage to collect enough nectar.");
        } else {
            System.out.println("This is the end! Beesy ran out of energy.");
        }

        field[beeRow][beeCol] = "B";
        for (String[] rows : field) {
            System.out.println(String.join("",rows));
        }
    }

    public static int moveUp(int matrixParam, int currentBeeRow) {

        currentBeeRow--;
        if (currentBeeRow < 0) {
            currentBeeRow = matrixParam - 1;
        }
        return currentBeeRow;
    }

    public static int moveDown(int matrixParam, int currentBeeRow) {

        currentBeeRow++;
        if (currentBeeRow > matrixParam - 1) {
            currentBeeRow = 0;
        }
        return currentBeeRow;
    }

    public static int moveLeft(int matrixParam, int currentBeeCol) {

        currentBeeCol--;
        if (currentBeeCol < 0) {
            currentBeeCol = matrixParam - 1;
        }
        return currentBeeCol;
    }

    public static int moveRight(int matrixParam, int currentBeeCol) {

        currentBeeCol++;
        if (currentBeeCol > matrixParam - 1) {
            currentBeeCol = 0;
        }
        return currentBeeCol;
    }


}
