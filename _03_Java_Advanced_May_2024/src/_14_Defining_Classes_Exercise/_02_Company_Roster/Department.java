package _14_Defining_Classes_Exercise._02_Company_Roster;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private List<Employee> employees;


    public List<Employee> getEmployees() {
        return employees;
    }

    public Department() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public String getDepartmentName() {
        return getEmployees().get(0).getDepartment();

    }

    public double getAverageSalary() {

        return getEmployees().stream().mapToDouble(Employee::getSalary).average().getAsDouble();
    }

    @Override
    public String toString() {
        StringBuilder emplOut = new StringBuilder();

        for (Employee employee : getEmployees()) {
            emplOut.append(String.format("%s %.2f %s %d%n", employee.getName(), employee.getSalary(), employee.getEmail(), employee.getAge()));
        }

        return emplOut.toString();
    }
}
