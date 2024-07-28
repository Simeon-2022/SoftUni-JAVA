package _09_Interfaces_and_Abstraction_Lab.sayHello;

public class Bulgarian implements Person {

    public Bulgarian(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String sayHello() {
        return "Здравей";
    }
}
