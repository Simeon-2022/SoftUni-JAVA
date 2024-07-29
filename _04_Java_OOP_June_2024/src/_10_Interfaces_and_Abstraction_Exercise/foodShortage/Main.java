package foodShortage;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Citizen> citizens = new ArrayList<>();
        List<Rebel> rebels = new ArrayList<>();

        int N = Integer.parseInt(scanner.nextLine());

        while (N-- > 0) {

            //"{name} {age} {id} {birthdate}"

            String[] info = scanner.nextLine().split(" ");

            int dataCount = info.length;

            switch (dataCount) {
                case 4:
                    citizens.add(new Citizen(info[0], Integer.parseInt(info[1]), info[2], info[3]));

                    break;

                case 3:
                    rebels.add(new Rebel(info[0], Integer.parseInt(info[1]), info[2]));
                    break;
            }

        }


        String command = scanner.nextLine();

        while (!command.equals("End")) {

            int indexCitizens = getCitizenIndex(citizens, command);
            int indexRebels = getRebelsIndex(rebels, command);

            if (indexCitizens != -1) {
                citizens.get(indexCitizens).buyFood();

            } else if (indexRebels != -1) {
                rebels.get(indexRebels).buyFood();

            }

            command = scanner.nextLine();
        }

        int sumFoodCitizen = citizens.stream().mapToInt(Citizen::getFood).sum();
        int sumFoodRebel = rebels.stream().mapToInt(Rebel::getFood).sum();;
        System.out.println(sumFoodCitizen + sumFoodRebel);

    }


    private static int getCitizenIndex(List<Citizen> citizens, String name) {

        for (int i = 0; i < citizens.size(); i++) {

            if (citizens.get(i).getName().equals(name)) {
                return i;
            }
        }

        return -1;
    }

    private static int getRebelsIndex(List<Rebel> rebels, String name) {

        for (int i = 0; i < rebels.size(); i++) {

            if (rebels.get(i).getName().equals(name)) {
                return i;
            }
        }

        return -1;
    }
}