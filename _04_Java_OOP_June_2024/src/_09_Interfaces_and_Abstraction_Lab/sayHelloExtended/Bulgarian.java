package _09_Interfaces_and_Abstraction_Lab.sayHelloExtended;

public class Bulgarian extends BasePerson{

  //  private String name;

    public Bulgarian(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Здравей";
    }
}
