package _24_Regular_Exam;

import java.util.*;

public class _01_ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> packagesInput = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toList();
        List<Integer> couriersInput = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toList();


        ArrayDeque<Integer> packages = new ArrayDeque<>();
        packages.addAll(packagesInput);

        ArrayDeque<Integer> couriers = new ArrayDeque<>();
        couriers.addAll(couriersInput);

        int totalWeightDelivered = 0;
        while (!packages.isEmpty() && !couriers.isEmpty()) {

            int packageWeight = packages.pollLast();
            int couriersCapacity = couriers.pollFirst();

            if (couriersCapacity >= packageWeight) {

                totalWeightDelivered += packageWeight;

                couriersCapacity -= 2 * packageWeight;

                if (couriersCapacity > 0) {

                    couriers.offerLast(couriersCapacity);
                }
            } else {
                totalWeightDelivered += couriersCapacity;
                packageWeight -= couriersCapacity;
                packages.offerLast(packageWeight);
            }
        }

        System.out.printf("Total weight: %d kg%n", totalWeightDelivered);

        if (packages.isEmpty() && couriers.isEmpty()) {

            System.out.println("Congratulations, all packages were delivered successfully by the couriers today.");

        } else if (!packages.isEmpty() && couriers.isEmpty()) {

            System.out.printf("Unfortunately, there are no more available couriers to deliver the following packages: %s", packages.toString().replaceAll("[\\[\\]]",""));
        } else if (packages.isEmpty() && !couriers.isEmpty()) {
            System.out.printf("Couriers are still on duty: %s but there are no more packages to deliver.", couriers.toString().replaceAll("[\\[\\]]",""));
        }
    }
}
