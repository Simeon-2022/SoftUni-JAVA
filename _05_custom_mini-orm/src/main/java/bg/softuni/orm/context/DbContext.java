package bg.softuni.orm.context;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public interface DbContext<E> {

    //Insert operation
    boolean persist(E entity) throws IllegalAccessException, SQLException;

    // Select
    Iterable<E> find(Class<E> table);

    // Select ... where ...
    Iterable<E> find(Class<E> table, String where);

    //Select ... limit 1
    E findFirst(Class<E> table) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;

    //Select ... where ... limit 1
    E findFirst(Class<E> table, String where) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;


}
