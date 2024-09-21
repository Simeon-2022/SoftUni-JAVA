package p04_BubbleSortTest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BubbleTest {

    @Test
    void whenProvideUnorderedArrayOfInts_ThenSortTheArrayInAscendingOrder() {

        int[] unsortedArray = {6, 1, 5, 2, 7, 3, 0, 4};

        int[] sortedArray = {0, 1, 2, 3, 4, 5, 6, 7};

        Bubble.sort(unsortedArray);

        assertArrayEquals(sortedArray, unsortedArray);
    }



}