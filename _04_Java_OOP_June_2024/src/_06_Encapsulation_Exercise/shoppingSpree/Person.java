package _06_Encapsulation_Exercise.shoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private double money;
    private List<Product> products;

    public Person (String name,  double money) {
        setName(name);
        setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName (String name) {
        if (name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        this.name = name;
    }

    private void setMoney (double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }

        this.money = money;
    }

   public String getName() {
        return name;
   }


   public void buyProduct (Product product) {

       if (money >= product.getCost()) {
           setMoney(money - product.getCost());
       } else {
           System.out.println(name + " can't afford " + product.getName());
       }
   }



}
