package p02_ExtendedDatabase;

import org.junit.jupiter.api.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {

    @Test
    void cannot_Add_Null_Person_Object_To_DataBase_ThenThrowsOperationNotSupportedException() throws OperationNotSupportedException {

        Person[] persons = new Person[1];

        Database database = new Database(persons);

        Person person = null;

        assertThrows(OperationNotSupportedException.class, () -> database.add(person));

    }


    @Test
    void when_Add_Person_Object_To_DataBase_ThenLengthIncreasesByOne() throws OperationNotSupportedException {

        Person person_1 = new Person(1, "Gosho");

        Person[] people = {person_1};

        Database database = new Database(people);

        int databaseSizeBeforeAddition = database.getElements().length;

        Person person_2 = new Person(2, "Petar");
        database.add(person_2);

        assertEquals(databaseSizeBeforeAddition + 1,database.getElements().length);

    }

    @Test
    void when_Attempt_To_Remove_OutOfBoundsElement_ThenThrowsOperationNotSupportedException() throws OperationNotSupportedException {

        Person[] people = {new Person(1, "Gosho")};

        Database database = new Database(people);
        database.remove();

        assertThrows(OperationNotSupportedException.class, database::remove);


    }


    @Test
    void findByUsernameWithValueNull_ThenExceptionIsThrown() throws OperationNotSupportedException {

        Person person_1 = new Person(1, "Gosho");
        Person person_2 = new Person(2, "Petar");

        Person[] people = {person_1, person_2};

        Database database = new Database(people);

        assertThrows(OperationNotSupportedException.class, () -> database.findByUsername(null));

    }

    @Test
    void findByUnknownUsernameNotInList_ThenExceptionIsThrown() throws OperationNotSupportedException {

        Person person_1 = new Person(1, "Gosho");
        Person person_2 = new Person(2, "Petar");

        Person[] people = {person_1, person_2};

        Database database = new Database(people);

        assertThrows(OperationNotSupportedException.class, () -> database.findByUsername("Simo"));

    }

    @Test
    void findByKnownUsernameInList() throws OperationNotSupportedException {

        Person person_1 = new Person(1, "Gosho");
        Person person_2 = new Person(2, "Petar");

        Person[] people = {person_1, person_2};

        Database database = new Database(people);

        assertEquals(person_1.getUsername(),database.findByUsername(person_1.getUsername()).getUsername());
        assertEquals(person_1.getId(),database.findByUsername(person_1.getUsername()).getId());
        assertEquals(person_1,database.findByUsername(person_1.getUsername()));
    }

    @Test
    void findByIdWithValueNull_ThenExceptionIsThrown() throws OperationNotSupportedException {

        Person person_1 = new Person(1, "Gosho");
        Person person_2 = new Person(2, "Petar");

        Person[] people = {person_1, person_2};

        Database database = new Database(people);

        assertThrows(OperationNotSupportedException.class, () -> database.findById(0));

    }


    @Test
    void findByKnownIdInList() throws OperationNotSupportedException {

        Person person_1 = new Person(1, "Gosho");
        Person person_2 = new Person(2, "Petar");

        Person[] people = {person_1, person_2};

        Database database = new Database(people);

        assertEquals(person_1,database.findById(1));
        assertEquals(person_1.getId(),database.findById(1).getId());
        assertEquals(person_1.getUsername(),database.findById(1).getUsername());
    }

    @Test
    void cannot_Create_Database_With_Array_Below_Minimum_Length_ThenThrowsOperationNotSupportedException() {
        Person[] people = new Person[17];
        assertThrows(OperationNotSupportedException.class, () -> new Database(people));

    }

    @Test
    void create_Database_With_Array_Within_Boundaries_ThenSuccessfullyCreated() {

        Person[] people = new Person[0];
        assertThrows(OperationNotSupportedException.class, () -> new Database(people));
    }

}