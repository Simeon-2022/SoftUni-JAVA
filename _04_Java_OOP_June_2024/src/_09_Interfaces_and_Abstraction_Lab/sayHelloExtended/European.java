package _09_Interfaces_and_Abstraction_Lab.sayHelloExtended;

public class European extends BasePerson{

    public European(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Hello";
    }
}
