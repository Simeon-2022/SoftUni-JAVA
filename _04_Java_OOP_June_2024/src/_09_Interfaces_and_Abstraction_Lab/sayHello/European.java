package _09_Interfaces_and_Abstraction_Lab.sayHello;

public class European implements Person{

    public European(String name) {
        this.name = name;
    }

    private String name;


    @Override
    public String getName() {
        return name;
    }
}
