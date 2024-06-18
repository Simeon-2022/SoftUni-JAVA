package _07_Sets_And_Maps_Advanced_Lab;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class _05_Average_Students_Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        TreeMap<String, List<Double>> studentsAndGrades = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] student = scanner.nextLine().split(" ");


            studentsAndGrades.putIfAbsent(student[0], new ArrayList<>());
            List<Double> grades = studentsAndGrades.get(student[0]);
            grades.add(Double.parseDouble(student[1]));


/*
            if (!studentsAndGrades.containsKey(student[0])) {
                List<Double> grades = new ArrayList<>();

                grades.add(Double.parseDouble(student[1]));
                studentsAndGrades.put(student[0], grades);

            } else {
                List<Double> grades = studentsAndGrades.get(student[0]);
                grades.add(Double.parseDouble(student[1]));
            }
*/
        }

        for (Map.Entry<String, List<Double>> student : studentsAndGrades.entrySet()) {

            double sum = 0;
            for (Double v : student.getValue()) {
                sum += v;
            }
            double average = sum / student.getValue().size();
  /*          double average =  student.getValue()
                    .stream()
                    .mapToDouble(Double::doubleValue)
                    .average()
                    .getAsDouble();*/

            String grades = student.getValue().stream().map( g -> String.format("%.2f",g)).collect(Collectors.joining(" "));

            System.out.println(String.format("%s -> %s (avg: %.2f)", student.getKey() , grades, average) );
         }


    }
}
