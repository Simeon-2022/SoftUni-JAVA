package _14_Defining_Classes_Exercise;


//_02_Company_Roster
public class Employee {

    //name, salary, position, department, email, and age.
    // The name, salary, position, and department are mandatory, while the rest are optional.

    private String name;
    private double salary;
    private String position;

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    private String department;
    private String email;
    private int age;

    public Employee(String name, double salary, String position, String department, String email, int age) {

        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }

    public Employee(String name, double salary, String position, String department) {
        this(name, salary, position, department,"n/a", -1);
    }

    public Employee(String name, double salary, String position, String department, String email) {
        this(name, salary, position, department,email, -1);
    }

    public Employee(String name, double salary, String position, String department, int age) {
        this(name, salary, position, department, "n/a", age);
    }

    public double getSalary() {
        return this.salary;
    }


}
