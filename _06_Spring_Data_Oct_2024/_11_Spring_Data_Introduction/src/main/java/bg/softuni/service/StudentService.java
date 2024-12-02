package bg.softuni.service;

import bg.softuni.entities.Student;

public interface StudentService {
    void register(Student student);

    Student get(int id);
}
