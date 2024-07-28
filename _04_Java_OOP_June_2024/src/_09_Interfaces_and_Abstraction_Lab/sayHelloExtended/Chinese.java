package _09_Interfaces_and_Abstraction_Lab.sayHelloExtended;

public class Chinese extends BasePerson {

    public Chinese(String name) {
        super(name);
    }


    @Override
    public String sayHello() {
        return "Djydjybydjy";
    }
}
