package Retake;

import java.util.Scanner;

public class TaskTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());

        String[][] field = new String[N][N];

        int personRow = 0;
        int personCol = 0;

        for (int row = 0; row < field.length; row++) {
            String[] rowInput = scanner.nextLine().split(" ");
            for (int col = 0; col < rowInput.length; col++) {

                if (rowInput[col].equals("P")) {
                    personRow = row;
                    personCol = col;
                    field[personRow][personCol] = ".";
                } else {

                    field[row][col] = rowInput[col];
                }
            }
        }

        int playerStars = 2;

        boolean starsCollected = false;

        while (true) {

            String command = scanner.nextLine(); //"up", "down", "left", and "right"

            int previousRow = personRow;
            int previousCol = personCol;
            switch (command) {

                case "up":

                    if (personRow - 1 < 0) {
                        personRow = 0;
                        personCol = 0;
                    } else {

                        personRow--;// = moveUp(N, personRow);
                    }

                    String symbolUp = field[personRow][personCol];

                    if (symbolUp.equals("#")) {
                        personRow = previousRow;
                        playerStars--;

                    } else if (symbolUp.equals("*")) {
                        field[personRow][personCol] = ".";
                        playerStars++;
                    }

                    break;
                case "down":

                    if (personRow + 1 > N - 1) {
                        personRow = 0;
                        personCol = 0;
                    } else {

                        personRow++;// = moveDown(N, personRow);
                    }

                    String symbolDown = field[personRow][personCol];
                    if (symbolDown.equals("#")) {
                        personRow = previousRow;
                        playerStars--;

                    } else if (symbolDown.equals("*")) {
                        field[personRow][personCol] = ".";
                        playerStars++;
                    }


                    break;
                case "left":

                    if (personCol - 1 < 0) {
                        personRow = 0;
                        personCol = 0;
                    } else {

                        personCol--;// = moveDown(N, personRow);
                    }

                    String symbolLeft = field[personRow][personCol];

                    if (symbolLeft.equals("#")) {
                        personCol = previousCol;
                        playerStars--;

                    } else if (symbolLeft.equals("*")) {
                        field[personRow][personCol] = ".";
                        playerStars++;
                    }


                    break;
                case "right":


                    if (personCol + 1 > N - 1) {
                        personRow = 0;
                        personCol = 0;
                    } else {

                        personCol++;// = moveDown(N, personRow);
                    }

                    String symbolRight = field[personRow][personCol];

                    if (symbolRight.equals("#")) {
                        personCol = previousCol;
                        playerStars--;

                    } else if (symbolRight.equals("*")) {
                        field[personRow][personCol] = ".";
                        playerStars++;
                    }

                    break;
            }
            if (playerStars == 10) {
                starsCollected = true;
                field[personRow][personCol] = "P";
                break;
            }

            if (playerStars == 0) {
                field[personRow][personCol] = "P";

                break;
            }

        }

        if (starsCollected) {
            System.out.println("You won! You have collected 10 stars.");
        } else {
            System.out.println("Game over! You are out of any stars.");
        }

        System.out.printf("Your final position is [%d, %d]%n", personRow,personCol);


        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field.length; col++) {

                System.out.print(field[row][col] + " ");
            }
            System.out.println();
        }

    }


}