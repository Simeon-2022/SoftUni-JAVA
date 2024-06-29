package _03_Working_with_Abstarction_Lab._01_Rhombus_of_Stars;

import java.util.Scanner;

public class _01_Rhombus_of_Stars {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int tokenCount = Integer.parseInt(scanner.nextLine());

        printTopPart("* ", tokenCount);
        printMiddlePart("* ", tokenCount);
        printBottomPart("* ", tokenCount);
    }

    public static void printToken(String token, int count) {
        int start = 0;
        while (start < count) {
            System.out.print(token);
            start++;
        }
    }

    public static void printTopPart(String token, int starCount) {

        for (int row = 1; row < starCount; row++) {

            printToken(" ", starCount - row);

            printToken(token, row);

            System.out.println();
        }
    }

    public static void printMiddlePart(String token, int starCount) {
        printToken(token, starCount);
        System.out.println();
    }

    public static void printBottomPart(String token, int starCount) {
        for (int row = 1;  row < starCount; row++) {

            printToken(" ",row);

            printToken(token, starCount - row);

            System.out.println();
        }
    }
}
