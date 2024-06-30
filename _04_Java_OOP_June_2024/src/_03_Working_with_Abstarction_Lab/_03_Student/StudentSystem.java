package _03_Working_with_Abstarction_Lab._03_Student;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private final Map<String, Student> repo;

    public StudentSystem() {
        this.repo = new HashMap<>();
    }

    public void parseCommand(String input) {

        String[] commands = input.split(" ");

        String command = commands[0];
        String name = commands[1];

        if (command.equals("Create")) {

            int age = Integer.parseInt(commands[2]);
            double grade = Double.parseDouble(commands[3]);

            repo.putIfAbsent(name, new Student(name, age, grade));
            return;
        }
        //if (command.equals("Show"))

        Student student = repo.get(name);
        if (student != null) {
            System.out.println(student.toString());
        }
    }
}

