package wildFarm;

public class Tiger extends Feline{


    public Tiger(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }

    @Override
    void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    void eat(Food food) {
        if (food instanceof Meat) {
            setFoodEaten(food.getQuantity());
        } else {
            throw new IllegalArgumentException("Tigers are not eating that type of food!");
        }
    }
}
