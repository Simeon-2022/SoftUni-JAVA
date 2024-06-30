package _03_Working_with_Abstarction_Lab._03_Student;

public record Student(String name, int age, double grade) {

    @Override
    public String toString() {
        return String.format("%s is %s years old. %s", name, age, getPostfix());
    }

    public String getPostfix(){
        String view = "Very nice person.";

        if (grade >= 5.00) {
            view = "Excellent student.";
        } else if (grade >= 3.50) {
            view = "Average student.";
        }
        return view;
    }

}