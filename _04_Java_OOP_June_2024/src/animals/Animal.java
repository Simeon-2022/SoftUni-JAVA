package animals;

public class Animal {

    private String name;
    private int age;

    private String gender;

    public Animal(String name, int age, String gender) {
        this.name = name;
        setAge(age);
        setGender(gender);
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.age = age;
    }

    public void setGender(String gender) {
        if (gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female")) {
            this.gender = gender;
        } else {
            throw new IllegalArgumentException("Invalid input!");
        }

    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String produceSound() {
        return "Undefined";
    }

    @Override
    public String toString() {
        return String.format("%s%n" +
                        "%s %d %s%n" +
                        "%s",
                this.getClass().getSimpleName(),
                getName(),
                getAge(),
                getGender(),
                produceSound());
    }
}
