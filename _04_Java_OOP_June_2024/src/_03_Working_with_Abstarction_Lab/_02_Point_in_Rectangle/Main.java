package _03_Working_with_Abstarction_Lab._02_Point_in_Rectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Rectangle rectangle = getRectangle(getArrayInput(scanner));
        int N = Integer.parseInt(scanner.nextLine());

        while (N-- > 0) {

            // Point point = createPoint(getArrayInput(scanner));
            System.out.println(rectangle.contains(createPoint(getArrayInput(scanner))));
        }
    }

    private static Rectangle getRectangle(int[] rectInput) {
        Rectangle rectangle = new Rectangle(new Point(rectInput[0], rectInput[1]), new Point(rectInput[2], rectInput[3]));
        return rectangle;
    }

    public static Point createPoint(int[] pointCoordinates) {
        return new Point(pointCoordinates[0], pointCoordinates[1]);
    }

    public static int[] getArrayInput(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

}

