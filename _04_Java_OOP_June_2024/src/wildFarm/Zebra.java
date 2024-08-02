package wildFarm;

public class Zebra extends Mammal{

    public Zebra(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }

    @Override
    void makeSound() {
        System.out.println("Zs");
    }

    @Override
    void eat(Food food) {
        if (food instanceof Vegetable) {
            setFoodEaten(food.getQuantity());
        } else {
            throw new IllegalArgumentException("Zebra's are not eating that type of food!");
        }
    }
}
