package wildFarm;

import java.text.DecimalFormat;

public class Cat extends Feline{

    private final String catBreed;


    public Cat(String animalType, String animalName, Double animalWeight, String livingRegion, String catBreed) {
        super(animalType, animalName, animalWeight,livingRegion);
        this.catBreed = catBreed;
    }

    public String getCatBreed() {
        return catBreed;
    }

    @Override
    public String getLivingRegion() {
        return livingRegion;
    }

    @Override
    void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    void eat(Food food) {
        setFoodEaten(food.getQuantity());
    }

    @Override
    public String toString() {

        DecimalFormat format = new DecimalFormat("#.##");
        //{AnimalType} [{AnimalName}, {CatBreed}, {AnimalWeight}, {AnimalLivingRegion}, {FoodEaten}]

        return String.format("%s[%s, %s, %s, %s, %d]", getAnimalType(), getAnimalName(), getCatBreed(), format.format(getAnimalWeight()), getLivingRegion(), getFoodEaten());
    }
}
