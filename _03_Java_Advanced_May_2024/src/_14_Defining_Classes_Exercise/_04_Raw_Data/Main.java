package _14_Defining_Classes_Exercise._04_Raw_Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Car> cars = new ArrayList<>();

        int N = Integer.parseInt(scanner.nextLine());


        for (int i = 0; i < N; i++) {

            String[] input = scanner.nextLine().split(" ");

            String model = input[0];

            int speed = Integer.parseInt(input[1]);
            int power = Integer.parseInt(input[2]);
            Engine engine = new Engine(speed, power);

            int weight = Integer.parseInt(input[3]);
            String type = input[4];
            Cargo cargo = new Cargo(weight, type);

            double tyre1Pressure = Double.parseDouble(input[5]);
            int tyre1Age = Integer.parseInt(input[6]);
            double tyre2Pressure = Double.parseDouble(input[7]);
            int tyre2Age = Integer.parseInt(input[8]);
            double tyre3Pressure = Double.parseDouble(input[9]);
            int tyre3Age = Integer.parseInt(input[10]);
            double tyre4Pressure = Double.parseDouble(input[11]);
            int tyre4Age = Integer.parseInt(input[12]);

            Tyre tyre1 = new Tyre(tyre1Pressure, tyre1Age);
            Tyre tyre2 = new Tyre(tyre2Pressure, tyre2Age);
            Tyre tyre3 = new Tyre(tyre3Pressure, tyre3Age);
            Tyre tyre4 = new Tyre(tyre4Pressure, tyre4Age);

            Car car = new Car(model, engine, cargo, tyre1, tyre2, tyre3, tyre4);
            cars.add(car);
        }

        String cargoType = scanner.nextLine();


        if (cargoType.equals("fragile")) {
            cars.forEach(car -> {
                if (car.getTyre1().getPressure() < 1 || car.getTyre2().getPressure() < 1 || car.getTyre3().getPressure() < 1 || car.getTyre4().getPressure() < 1) {

                    System.out.println(String.format("%s", car));
                }

            });
        } else {
            cars.forEach(car -> {
                if (car.getEngine().getPower() > 250) {

                    System.out.println(String.format("%s", car));
                }

            });
        }
    }
}
