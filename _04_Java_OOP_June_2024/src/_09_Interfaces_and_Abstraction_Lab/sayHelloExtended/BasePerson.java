package _09_Interfaces_and_Abstraction_Lab.sayHelloExtended;

public abstract class BasePerson implements Person{

    private String name;

    protected BasePerson(String name) {
       this.setName(name);
    }

    @Override
    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }
}
