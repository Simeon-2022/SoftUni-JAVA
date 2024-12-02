import bg.softuni.entities.vehicle.Bike;
import bg.softuni.entities.vehicle.Car;
import bg.softuni.entities.vehicle.Vehicle;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-relations");
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();


/*
        Bike bike = new Bike();
        bike.setWheelSize(26);

        Car car = new Car();
        car.setPaintCode("red");

        entityManager.persist(bike);
        entityManager.persist(car);

        List<Vehicle> vehicles = List.of(bike, car);

        System.out.println(vehicles.get(0).getId());
        System.out.println(vehicles.get(1).getId());*/

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
