package _06_Multidimensional_Arrays_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class _05_Matrix_shuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrxParams = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String[][] matrx = new String[matrxParams[0]][matrxParams[1]];

        fillMatrix(matrx, scanner);

        String input = scanner.nextLine();

        while (!"END".equals(input)) {

            String[] commands = input.split(" ");

            if (isValidCommand(commands, matrxParams[0], matrxParams[1])) {

                swapValues(commands, matrx);
                printMatrixOfStrings(matrx);
            } else {
                System.out.println("Invalid input!");

            }

            input = scanner.nextLine();
        }
    }

    public static void printMatrixOfStrings(String[][] matrx) {
        for (String[] str : matrx) {
            System.out.println(String.join(" ", str));
        }
    }

    private static void swapValues(String[] commands, String[][] matrx) {
        int row1 = Integer.parseInt(commands[1]);
        int col1 = Integer.parseInt(commands[2]);
        int row2 = Integer.parseInt(commands[3]);
        int col2 = Integer.parseInt(commands[4]);

        String swapValue = matrx[row1][col1];
        matrx[row1][col1] = matrx[row2][col2];
        matrx[row2][col2] = swapValue;
    }

    public static boolean isValidCommand(String[] commands, int rowParam, int colParam) {

        if (commands.length == 5 && commands[0].equals("swap")) {
            try {

                Integer.parseInt(commands[1]);
                Integer.parseInt(commands[2]);
                Integer.parseInt(commands[3]);
                Integer.parseInt(commands[4]);

            } catch (Exception e) {
               // System.out.println("MSG:" + e);
               // e.printStackTrace();
                return false;
            }

            boolean row1 = Integer.parseInt(commands[1]) >= 0 && Integer.parseInt(commands[1]) < rowParam;
            boolean col1 = Integer.parseInt(commands[2]) >= 0 && Integer.parseInt(commands[2]) < colParam;
            boolean row2 = Integer.parseInt(commands[3]) >= 0 && Integer.parseInt(commands[3]) < rowParam;
            boolean col2 = Integer.parseInt(commands[4]) >= 0 && Integer.parseInt(commands[4]) < colParam;

            return row1 && col1 && row2 && col2;
        }
        return false;


    }

    public static void fillMatrix(String[][] matrx, Scanner scanner) {

        for (int i = 0; i < matrx.length; i++) {
            matrx[i] = scanner.nextLine().split(" ");

        }
    }
}
