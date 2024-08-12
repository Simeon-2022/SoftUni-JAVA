package _17_Exceptions_and_Error_Handling_Lab;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class EnterNumbers {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) throws IOException {



        int[] arr = readNumber(1, 100);
        System.out.println(Arrays.toString(arr).replaceAll("[\\[\\]]", ""));



    }

    private static int[] readNumber(int begin, int end) throws IOException {

        int[] arr = new int[10];
        int indexCount = 0;

        while (indexCount < 10) {

            String input = SCANNER.nextLine();
            try {
                int n = Integer.parseInt(input);

                if (n > begin && n < end) {
                    arr[indexCount++] = n;
                    begin = n;
                } else {
                    throw new IOException("Your number is not in range %d - 100!".formatted(begin));
                }
            } catch (Exception e) {
                if (e.getMessage().endsWith("\"" + input + "\"")) {

                    System.out.println("Invalid Number!");
                } else {
                    System.out.println(e.getMessage());
                }
            }
        }
        return arr;
    }
}
