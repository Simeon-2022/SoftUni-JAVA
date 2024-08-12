package surfers;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Beach {
    //TODO
    private String name;
    private int surfboardsForRent;
    private List<Surfer> surfers;

    public Beach(String name, int surfboardsForRent) {
        this.name = name;
        this.surfboardsForRent = surfboardsForRent;
        this.surfers = new ArrayList<>();
    }

    public String addSurfer(Surfer surfer) {

        String msg = "";

        if (surfboardsForRent <= 0) {
            return "There are no free surfboards.";
        }

        if (surfer.getOwnsASurfBoard()) {
            surfers.add(surfer);
            msg = String.format("Surfer %s added.", surfer.getName());
        } else {

            if (surfer.getMoney() >= 50) {

                surfers.add(surfer);
                surfboardsForRent--;

            } else {
                return String.format("%s has not enough money to rent a surfboard.", surfer.getName());
            }
        }

        return msg;


    }

    public Boolean removeSurfer(String name) {

        for (Surfer surfer : surfers) {
            if (surfer.getName().equals(name)) {
                return surfers.remove(surfer);

            }
        }
        return false;
    }

    public String getMostExperiencedSurfer() {

        if (surfers.isEmpty()) {
            return "There are no surfers.";
        }
        surfers.sort(Comparator.comparingInt(Surfer::getExperience));
        return String.format("%s is most experienced surfer with %d years experience.", surfers.get(1).getName(), surfers.get(1).getExperience());

    }

    public String getSurfer(String name) {

        for (Surfer surfer : surfers) {
            if (surfer.getName().equals(name)) {

                return String.format("%s", surfer.getName());

            }
        }

        return null;

    }

    public int getCount() {

        return (int) surfers.stream().count();
    }

    public String getSurfersWithPersonalSurfboards() {
        List<String> names = new ArrayList<>();

        for (Surfer surfer : surfers) {
            if (surfer.getOwnsASurfBoard()) {

                names.add(surfer.getName());

            }
        }
        if (names.isEmpty()) {
            return "There are no surfers.";
        }

        String allNames = String.join(", ", names);
        return String.format("Surfers who have their own surfboards: %s", allNames);
    }

    public void getReport() {

        if (surfers.isEmpty()) {

            System.out.println(String.format("There are no surfers on %s beach.", getName()));
        }

        int idx = 1;
        System.out.printf("Beach %f was visited by the following surfers:%n", getName());

        for (Surfer surfer : surfers) {
            if (surfer.getExperience() > 0) {
                System.out.printf("%d. %s with %d years experience.%n ",idx, surfer.getName(), surfer.getExperience());
            }

        }

    }


    public String getName() {
        return name;
    }

    public int getSurfboardsForRent() {
        return surfboardsForRent;
    }

    public List<Surfer> getSurfers() {
        return surfers;
    }
}
