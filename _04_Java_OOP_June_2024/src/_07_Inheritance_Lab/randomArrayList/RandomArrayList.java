package _07_Inheritance_Lab.randomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<T> extends ArrayList<T> {

    public T getRandomElement() {

        int begin = 0;
        int end = size();

        Random random = new Random();
        int index = random.nextInt(begin, end);
        T getResult = get(index);

        remove(get(index));
        return getResult;
    }


}
