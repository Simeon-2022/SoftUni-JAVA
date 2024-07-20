package _07_Inheritance_Lab.randomArrayList;

public class Main {
    public static void main(String[] args) {

        RandomArrayList<Integer> test = new RandomArrayList<>();
        test.add(4);
        test.add(5);
        test.add(6);
        test.add(7);

        System.out.println(test.getRandomElement());


    }
}
