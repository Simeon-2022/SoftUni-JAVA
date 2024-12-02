package bg.softuni;

import bg.softuni.entities.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("school-unit");
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();

        Student insert = new Student("Pesho");
        entityManager.persist(insert);

        //Student found = entityManager.find(Student.class, 3);
        //System.out.println(found);

        List<Student> selectAll = entityManager.createQuery("FROM Student", Student.class).getResultList();

        for (Student student : selectAll) {
            System.out.println(student);
        }

        Student student = selectAll.get(selectAll.size() - 1);
        entityManager.remove(student);

        selectAll = entityManager.createQuery("FROM Student", Student.class).getResultList();

        for (Student available : selectAll) {
            System.out.println(available);
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
