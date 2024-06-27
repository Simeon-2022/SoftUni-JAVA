package _14_Defining_Classes_Exercise._02_Company_Roster;

import java.util.*;

public class Main_Company_Roster {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());

        List<Department> departments = new ArrayList<>();

        while (N-- > 0) {

            String[] empData = scanner.nextLine().split(" ");

            String name = empData[0];
            double salary = Double.parseDouble(empData[1]);
            String position = empData[2];
            String departmentName = empData[3];

            Employee employee;

            if (empData.length == 6) {

                String email = empData[4];
                int age = Integer.parseInt(empData[5]);

                employee = new Employee(name, salary, position, departmentName, email, age);
            } else if (empData.length == 5) {

                if (isNumber(empData[4])) {
                    int age = Integer.parseInt(empData[4]);
                    employee = new Employee(name, salary, position, departmentName, age);

                } else {
                    String email = empData[4];
                    employee = new Employee(name, salary, position, departmentName, email);
                }
            } else {
                employee = new Employee(name, salary, position, departmentName);
            }

            int departmentIndex = getDepartmentIndex(departments, departmentName);

            if ( departmentIndex != -1) {
                departments.get(departmentIndex).addEmployee(employee);
            } else {
                Department department =  new Department();
                department.addEmployee(employee);
                departments.add(department);
            }

        }

        sortingBySalary(departments);

        System.out.println("Highest Average Salary: " + departments.get(0).getDepartmentName());
        System.out.println(departments.get(0));

    }

    private static void sortingBySalary(List<Department> departments) {
        departments.sort(Comparator.comparingDouble(Department::getAverageSalary).reversed());

        for (Department department : departments) {
            department.getEmployees().sort(Comparator.comparing(Employee::getSalary).reversed());
        }
    }

    public static int getDepartmentIndex(List<Department> departments, String departmentName) {

        int index = 0;
        for (Department department : departments) {
            if (department.getDepartmentName().equals(departmentName)) {
            return index;
            }
            index++;
        }
        return -1;
    }

    public static boolean isNumber(String field) {
        boolean check = true;

        for (int i = 0; i < field.length(); i++) {

            if (!Character.isDigit(field.charAt(i))) {
                check = false;
                break;
            }
        }
        return check;
    }
}
