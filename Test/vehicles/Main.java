package vehicles;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        String[] carInput = scanner.nextLine().split(" ");
        String[] truckInput = scanner.nextLine().split(" ");
        int iterations = Integer.parseInt(scanner.nextLine());

        Vehicle car = new Car(Double.parseDouble(carInput[1]), Double.parseDouble(carInput[2]));
        Vehicle truck = new Truck(Double.parseDouble(truckInput[1]), Double.parseDouble(truckInput[2]));

        while (iterations-- > 0) {
            String[] vehicleInstructions = scanner.nextLine().split(" ");

            String instruction = vehicleInstructions[0];
            String type = vehicleInstructions[1];
            switch (type) {
                case "Car":

                    if (instruction.equals("Drive")) {
                        double distance = Double.parseDouble(vehicleInstructions[2]);

                        try {
                            car.drive(distance);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } else if (instruction.equals("Refuel")) {

                        double fuel = Double.parseDouble(vehicleInstructions[2]);
                        car.refuel(fuel);
                    }
                    break;
                case "Truck":
                    if (instruction.equals("Drive")) {
                        double distance = Double.parseDouble(vehicleInstructions[2]);

                        try {
                            truck.drive(distance);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } else if (instruction.equals("Refuel")) {

                        double fuel = Double.parseDouble(vehicleInstructions[2]);
                        truck.refuel(fuel);
                    }
                    break;
            }

        }

        System.out.println(car);
        System.out.println(truck);
    }
}
