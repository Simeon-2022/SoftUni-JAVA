package wildFarm;

public class Mouse extends Mammal{


    public Mouse(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }

    @Override
    void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    void eat(Food food) {
        if (food instanceof Vegetable) {
            setFoodEaten(food.getQuantity());
        } else {
            throw new IllegalArgumentException("Mice are not eating that type of food!");
        }
    }
}
