package bg.softuni.entities.university;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "students")
public class Student extends Person {

    @Column(name = "average_grade")
    private double averageGrade;

    @Basic
    private int attendance;

    @ManyToMany(mappedBy = "students")
    private List<Course> courses;

    public Student(){
        super();
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }
}
