package bg.softuni;

import bg.softuni.entities.User;
import bg.softuni.orm.config.MyConnector;
import bg.softuni.orm.context.EntityManager;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws SQLException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {

        MyConnector.createConnection("root", "MySQLRootPass@01", "mini_orm");

        Connection connection = MyConnector.getConnection();
        EntityManager<User> em = new EntityManager<>(connection);

        em.doCreate(User.class);
        em.doAlter(User.class);
        //   em.delete(User.class, "id = 1");
        //User user1 = new User("user", "pass", 20, LocalDate.now());
        User user2 = new User("user2", "pass2", 22, LocalDate.now());
        user2.setPhoneNumber("12121212");
        user2.setSalary(333.33);
        em.persist(user2);

        User firstUser = em.findFirst(User.class);
        em.delete(firstUser);
        //       firstUser.setUsername("updated1");
        /*         em.persist(firstUser);*/

        Iterable<User> users = em.find(User.class);

        for (User user : users) {
            System.out.println(user);
        }

        //em.persist(new User("user","pass",20, LocalDate.now()));
        //em.persist(user1);

    }
}
