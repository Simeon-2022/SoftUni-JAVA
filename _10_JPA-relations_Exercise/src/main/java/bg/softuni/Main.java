package bg.softuni;

import bg.softuni.entities.betting.Position;
import bg.softuni.entities.betting.PositionEnum;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-ex");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(new Position(PositionEnum.DF, "Defence Keeper"));











        em.getTransaction().commit();
        em.close();

    }
}
