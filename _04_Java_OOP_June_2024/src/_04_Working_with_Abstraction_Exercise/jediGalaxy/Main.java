package _04_Working_with_Abstraction_Exercise.jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = fillMatrix(scanner.nextLine());

        String command = scanner.nextLine();
        long sum = 0;

        while (!command.equals("Let the Force be with you")) {
            int[] jediCoordinates = getInput(command);
            int[] evilCoordinates = getInput(scanner.nextLine());

            evilMoveAndDestroyStars(evilCoordinates, matrix);
            sum += jediMoveAndCollectStars(jediCoordinates, matrix);

            command = scanner.nextLine();
        }

        System.out.println(sum);


    }

    public static void evilMoveAndDestroyStars(int[] coordinates , int[][] matrix) {
        int rowEvil = coordinates[0];
        int colEvil = coordinates[1];

        while (rowEvil >= 0 && colEvil >= 0) {
            if (isInMatrix(rowEvil,colEvil, matrix)) {
                matrix[rowEvil][colEvil] = 0;
            }
            rowEvil--;
            colEvil--;
        }
    }

    public static int jediMoveAndCollectStars(int[] coordinates , int[][] matrix) {
        int sumCollectedStars = 0;
        int rowIvo = coordinates[0];
        int colIvo = coordinates[1];

        while (rowIvo >= 0 && colIvo < matrix[1].length) {
            if (isInMatrix(rowIvo, colIvo, matrix)) {
                sumCollectedStars += matrix[rowIvo][colIvo];
            }

            colIvo++;
            rowIvo--;
        }
        return sumCollectedStars;
    }




    private static int[] getInput(String input) {
        return Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    private static boolean isInMatrix(int rowEvil, int colEvil, int [][] matrix) {
        return rowEvil >= 0 && rowEvil < matrix.length && colEvil >= 0 && colEvil < matrix[0].length;
    }
    private static int[][] fillMatrix(String input) {
        int[] dimestions = getInput(input);
        int x = dimestions[0];
        int y = dimestions[1];

        int[][] matrix = new int[x][y];

        int value = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matrix[i][j] = value++;
            }
        }

        return matrix;
    }

}
