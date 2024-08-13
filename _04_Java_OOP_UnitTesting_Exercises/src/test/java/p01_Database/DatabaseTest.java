package p01_Database;

import org.junit.jupiter.api.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
    @Test
    void cannot_Create_Database_With_Array_Above_Max_Length_ThenThrowsOperationNotSupportedException() {
        Integer[] arr = new Integer[17];
        //Assertions.assertThrows(OperationNotSupportedException.class, () -> {Database database = new Database(arr);});

        OperationNotSupportedException ex = assertThrows(OperationNotSupportedException.class, () -> new Database(arr));

        assertEquals(null, ex.getMessage(), "Wrong msg");
    }

    @Test
    void cannot_Create_Database_With_Array_Below_Minimum_Length_ThenThrowsOperationNotSupportedException() {
        // Integer[] arr = new Integer[0];
        Integer[] arr = new Integer[0];

        assertThrows(OperationNotSupportedException.class, () -> new Database(arr));

    }

    @Test
    void create_Database_With_Array_Within_Boundaries_ThenSuccessfullyCreated() throws OperationNotSupportedException {

        Integer[] arr = {1, 2, null, 4, 5, 6, 7, 8, null, 10, 11, 12, 13, 14, 15, 16};

        Database database = new Database(arr);

        Integer[] databaseElements = database.getElements();

        assertEquals(arr.length, databaseElements.length);
     //   assertArrayEquals(arr, databaseElements);
    }

    @Test
    void adding_Null_Element_To_Database_ThenThrowsOperationNotSupportedException() throws OperationNotSupportedException {

        Integer[] arr = {1, 2};
        Database database = new Database(arr);

        assertThrows(OperationNotSupportedException.class, () -> database.add(null));
    }

    @Test
    void adding_One_Element_To_Database_Then_LengthIsIncreasedByOne() throws OperationNotSupportedException {

        Integer[] arr = {1, 2};
        Database database = new Database(arr);

        Integer newNumberAdded = 3;
        int lengthBeforeAddition = database.getElements().length;
        database.add(newNumberAdded);
        int lengthAfterAddition = database.getElements().length;

        assertEquals(newNumberAdded, database.getElements()[lengthAfterAddition - 1]);

        assertEquals(lengthBeforeAddition + 1, database.getElements().length, "Length not equal");
    }

    @Test
    void removing_One_Element_Of_Database_Then_LengthIsDecreasedByOne() throws OperationNotSupportedException {

        Integer[] arr = {1, 2};
        Database database = new Database(arr);

        int lengthBeforeRemoval = database.getElements().length;
        int lastNumber = database.getElements()[lengthBeforeRemoval - 2];

        database.remove();
        int lengthAfterRemoval = database.getElements().length;
        int lastNumberAfterRemoval = database.getElements()[lengthAfterRemoval - 1];

        assertEquals(lengthBeforeRemoval - 1, database.getElements().length, "Length not equal");
        assertEquals(lastNumber,lastNumberAfterRemoval);
    }


    @Test
    void removing_Out_Of_Bounds_Element_Then_OperationNotSupportedExceptionIsThrown() throws OperationNotSupportedException {

        Integer[] arr = {1, 2};
        Database database = new Database(arr);

        database.remove();
        database.remove();

        assertThrows(OperationNotSupportedException.class, database::remove);

    }
}