package wildFarm;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {

    protected final String livingRegion;


    public Mammal(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight);
        this.livingRegion = livingRegion;
    }


    public String getLivingRegion() {
        return livingRegion;
    }

    @Override
    public String toString() {

        DecimalFormat format = new DecimalFormat("#.##");

        // {AnimalType} [{AnimalName}, {AnimalWeight}, {AnimalLivingRegion}, {FoodEaten}]
        return String.format("%s[%s, %s, %s, %d]", getAnimalType(), getAnimalName(), format.format(getAnimalWeight()), getLivingRegion(), getFoodEaten());
    }
}
