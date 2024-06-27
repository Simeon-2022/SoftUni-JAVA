package vintageLocos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TrainStation {

    private final String name;
    private int capacity;
    private int railGauge;
    private final List<Locomotive> locomotives;

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getRailGauge() {
        return railGauge;
    }

    public void setRailGauge(int railGauge) {
        this.railGauge = railGauge;
    }

    public TrainStation(String name, int capacity, int railGauge) {
        this.name = name;
        this.capacity = capacity;
        this.railGauge = railGauge;
        this.locomotives = new ArrayList<>();
    }


    public void addLocomotive(Locomotive locomotive) {
        if (getCapacity() <= 0) {
            System.out.println("This train station is full!");

        } else if (getRailGauge() != locomotive.getGauge()) {

            System.out.printf("The rail gauge of this station does not match the locomotive gauge! Difference: %d mm.",
                    Math.abs(getRailGauge() - locomotive.getGauge()));
        } else {
            locomotives.add(locomotive);

        }
    }

    public boolean removeLocomotive(String name) {
        return locomotives.removeIf(l -> l.getName().equals(name));
    }

    public String getFastestLocomotive() {
        if (locomotives.isEmpty()) {
            return "There are no locomotives.";
        }

        int maxSpeed = Integer.MIN_VALUE;
        int indexCurrent = -1;
        int locoIndex = -1;
        for (Locomotive locomotive : locomotives) {
            indexCurrent++;
            if (maxSpeed < locomotive.getMaxSpeed()) {
                maxSpeed = locomotive.getMaxSpeed();
                locoIndex = indexCurrent;
            }
        }

        return String.format("%s is the fastest locomotive with a maximum speed of %d km/h."
                , locomotives.get(locoIndex).getName(), maxSpeed);


       //  locomotives.stream().max(Comparator.comparingInt(Locomotive::getMaxSpeed));

    }

    public Locomotive getLocomotive(String name) {

        for (Locomotive locomotive : locomotives) {
            if (locomotive.getName().equals(name)) {
            return locomotive;
            }
        }

        return null;
    }

    public int getCount() {
        return locomotives.size();
    }


    public String  getOldestLocomotive() {

        if (getCount() != 0) {
            List<Locomotive> locomotivesByDate = locomotives.stream().sorted(Comparator.comparing(Locomotive::getBuildDate)).toList();

            for (Locomotive locomotive : locomotivesByDate) {
                return locomotive.getName();
            }
        }

        return "There are no locomotives.";
    }

    public String getStatistics() {

        StringBuilder statistics = new StringBuilder();
        statistics.append(String.format("Locomotives departed from %s:%n", getName()));

        int num = 0;

        if (locomotives.isEmpty()) {
            return String.format("There are no locomotives departing from %s station.", getName());
        }

        for (Locomotive locomotive : locomotives) {
            statistics.append(String.format("%d. %s%n", ++num, locomotive.getName()));
        }
        return statistics.toString();
    }

}
