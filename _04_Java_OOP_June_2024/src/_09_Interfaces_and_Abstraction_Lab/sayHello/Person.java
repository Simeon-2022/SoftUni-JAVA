package _09_Interfaces_and_Abstraction_Lab.sayHello;

public interface Person {

    String getName();

    default String sayHello() {
        return "Hello";
    }
}
