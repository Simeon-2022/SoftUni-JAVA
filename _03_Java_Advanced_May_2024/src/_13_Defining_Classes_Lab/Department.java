package _13_Defining_Classes_Lab;

import _14_Defining_Classes_Exercise.Employee;

import java.util.ArrayList;
import java.util.List;

public class Department {

    //private Employee employee;
    private List<Employee> employees;

    public Department() {
        this.employees = new ArrayList<>();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addEmployees(Employee employee) {

        this.employees.add(employee);
    }
}
