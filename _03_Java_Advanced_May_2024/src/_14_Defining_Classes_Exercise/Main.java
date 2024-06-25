package _14_Defining_Classes_Exercise;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());

        Map<String, List<Employee>> departments = new LinkedHashMap<>();

        while (N-- > 0) {

            String[] empData = scanner.nextLine().split(" ");


            String name = empData[0];
            double salary = Double.parseDouble(empData[1]);
            String position = empData[2];
            String department = empData[3];

            Employee employee;

            if (empData.length == 6) {

                String email = empData[4];
                int age = Integer.parseInt(empData[5]);

                employee = new Employee(name, salary, position, department, email, age);
            } else if (empData.length == 5) {

                if (isNumber(empData[4])) {
                    int age = Integer.parseInt(empData[4]);
                    employee = new Employee(name, salary, position, department, age);

                } else {
                    String email = empData[4];
                    employee = new Employee(name, salary, position, department, email);
                }
            } else {
                employee = new Employee(name, salary, position, department);
            }

            if (departments.containsKey(department)) {
                List<Employee> employeeList;
                employeeList = departments.get(department);
                employeeList.add(employee);
            } else {

                departments.put(department, new ArrayList<>(Arrays.asList(employee)));
            }

        }



        LinkedHashMap<String, List<Employee>> departmentsSorted =
                departments.entrySet()
                        .stream()
                        .sorted((e1, e2) -> {
                            double average1 = e1.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble();
                            double average2 = e2.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble();

                            return Double.compare(average2, average1);
                        }).collect(Collectors.toMap(Map.Entry::getKey,
                                entry -> entry.getValue()
                                        .stream()
                                        .sorted((emp1, emp2) -> Double.compare(emp2.getSalary(), emp1.getSalary())) // for descending order
                                        .collect(Collectors.toList()),
                                (e1, e2) -> e1,
                                LinkedHashMap::new
                        ));

        for (Map.Entry<String, List<Employee>> department : departmentsSorted.entrySet()) {
            System.out.println("Highest Average Salary: " + department.getKey());
            for (Employee e : department.getValue()) {
                System.out.printf("%s %.2f %s %d%n",e.getName(), e.getSalary(), e.getEmail(), e.getAge());
            }
            break;
        }

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
