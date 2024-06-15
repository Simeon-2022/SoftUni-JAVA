package _06_Multidimensional_Arrays_Exercise;

import java.util.*;

public class _06_String_Matrix_Rotation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        String rotationDegree = scanner.nextLine();
        int degree = Integer.parseInt(rotationDegree.replaceAll("Rotate\\(", "")
                .replaceAll("\\)", ""));

        String input = scanner.nextLine();
        //int index = 0;


        List<String> matrxLines = new ArrayList<>();

        while (!"END".equals(input)) {

            // matrx = matrixResize(matrx);
            // matrx[index++] = input.split(" ");

            matrxLines.add(input);
            input = scanner.nextLine();
        }
        int rows = matrxLines.size();
        int columns = Collections.max(matrxLines,Comparator.comparing(String::length)).length();

        String[][] matrx = new String[rows][columns];

        spacePadding(matrx, matrxLines);

        switch (rotationIndex(degree)) {
            case 0:
                //   System.out.println("0:");
                printMatrixOfStrings(matrx);
                break;
            case 1:
                matrx = rotate90(matrx);
                //   System.out.println("90:");
                printMatrixOfStrings(matrx);
                break;
            case 2:
                //   System.out.println("180:");
                matrx = rotate180(matrx);
                printMatrixOfStrings(matrx);
                break;
            case 3:
                //  System.out.println("270:");
                matrx = rotate270(matrx);
                printMatrixOfStrings(matrx);
                break;
        }
    }

    public static int rotationIndex(int degree) {
        degree /= 90;
        int[] arr = {0, 1, 2, 3};

        for (int i = 1; i <= degree; i++) {

            int arrFirstIndex = arr[0];
            for (int y = 0; y < arr.length - 1; y++) {
                arr[y] = arr[y + 1];
            }
            arr[arr.length - 1] = arrFirstIndex;
        }
        return arr[0];
    }

    public static void printMatrixOfStrings(String[][] matrx) {
        for (String[] str : matrx) {
            System.out.println(String.join("", str));
        }
    }

    public static String[][] rotate90(String[][] matrx) {

        String[][] newMatrx = new String[matrx[0].length][matrx.length];

        for (int col = 0, newMatrxRow = 0; col < matrx[matrx.length - 1].length; col++, newMatrxRow++) {

            for (int row = matrx.length - 1, newMatrxCol = 0; row >= 0; row--, newMatrxCol++) {
                newMatrx[newMatrxRow][newMatrxCol] = matrx[row][col];
            }
        }
        return newMatrx;
    }

    public static String[][] rotate180(String[][] matrx) {

        String[][] newMatrx = new String[matrx.length][matrx[0].length];
        for (int row = matrx.length - 1, newMatrxRow = 0; row >= 0; row--, newMatrxRow++) {
            for (int col = matrx[row].length - 1, newMatrxCol = 0; col >= 0; col--, newMatrxCol++) {
                newMatrx[newMatrxRow][newMatrxCol] = matrx[row][col];
            }
        }
        return newMatrx;
    }

    public static String[][] rotate270(String[][] matrx) {

        String[][] newMatrx = new String[matrx[0].length][matrx.length];

        for (int col = matrx[matrx.length - 1].length - 1, newMatrxRow = 0; col >= 0; col--, newMatrxRow++) {

            for (int row = 0, newMatrxCol = 0; row < matrx.length; row++, newMatrxCol++) {
                newMatrx[newMatrxRow][newMatrxCol] = matrx[row][col];
            }
        }
        return newMatrx;
    }


    public static String[][] matrixResize(String[][] mtrx) {
        String[][] newMtrx = new String[mtrx.length + 1][];

        if (mtrx.length > 0) {

            for (int row = 0; row < mtrx.length; row++) {
                newMtrx[row] = new String[mtrx[row].length];

                for (int col = 0; col < mtrx[row].length; col++) {

                    newMtrx[row][col] = mtrx[row][col];
                }
            }

        }
        return newMtrx;
    }


    public static void spacePadding(String[][] matrx, List<String> words) {

        for (int row = 0; row < matrx.length; row++) {

            int charCount = 0;
            for (int col = 0; col < matrx[row].length; col++) {

                if (words.get(row).length() > charCount) {

                    matrx[row][col] = String.valueOf(words.get(row).charAt(col));
                    charCount++;
                } else {
                    matrx[row][col] = " ";
                }
            }
        }

/*        int rowlen = Integer.MIN_VALUE;
        for (String[] strings : matrx) {
            if (rowlen < strings[0].length()) {
                rowlen = strings[0].length();
            }
        }

        for (int row = 0; row < matrx.length; row++) {
            if (matrx[row].length < rowlen) {

                String[] newRow = new String[rowlen];
                Arrays.fill(newRow, " ");

                for (int i = 0; i < matrx[row][0].length(); i++) {
                    newRow[i] = String.valueOf(matrx[row][0].charAt(i));
                }
                matrx[row] = newRow;

            }
        }*/
    }
}
