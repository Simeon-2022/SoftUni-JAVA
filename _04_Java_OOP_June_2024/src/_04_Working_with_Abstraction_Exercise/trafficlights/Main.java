package _04_Working_with_Abstraction_Exercise.trafficlights;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Lights[] lightSeg = Arrays.stream(scanner.nextLine().split(" "))
                .map(light -> Lights.valueOf(light))
                .toArray(Lights[]::new);
        int n = Integer.parseInt(scanner.nextLine());

        //red, green, and yellow.

        for (int i = 0; i < n; i++) {

            printLights(lightSeg);
            updateLights(lightSeg);
        }
    }

    private static void printLights(Lights[] lightSeg) {
        for (Lights lights : lightSeg) {
            System.out.printf("%s ", lights.getNext());

        }
        System.out.println();
    }

    private static void updateLights(Lights[] lightSeg) {
        for (int i = 0; i < lightSeg.length; i++) {
            switch (lightSeg[i]) {
                case RED -> lightSeg[i] = Lights.GREEN;
                case GREEN -> lightSeg[i] = Lights.YELLOW;
                case YELLOW -> lightSeg[i] = Lights.RED;
            }
        }
    }
}
