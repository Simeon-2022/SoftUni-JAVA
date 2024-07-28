package foodShortage;

import java.lang.reflect.Method;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Buyer> buyers = new ArrayList<>();

        int N = Integer.parseInt(scanner.nextLine());

        while (N-- > 0) {

            //"{name} {age} {id} {birthdate}"

            String[] info = scanner.nextLine().split(" ");

            int dataCount = info.length;

            switch (dataCount) {
                case 4:
                    buyers.add(new Citizen(info[0], Integer.parseInt(info[1]), info[2], info[3]));

                    break;

                case 3:
                    buyers.add(new Rebel(info[0], Integer.parseInt(info[1]), info[2]));
                    break;
            }

        }

        buyers.forEach(Buyer::buyFood);

        String command = scanner.nextLine();

        int totalFood = 0;
        while (!command.equals("End")) {

            for (int i = 0; i < buyers.size(); i++) {

            }
            command = scanner.nextLine();
        }

    }
}