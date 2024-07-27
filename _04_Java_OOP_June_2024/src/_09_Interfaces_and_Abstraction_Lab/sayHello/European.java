package sayHello;

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
