package be.vives.ti.model;

import java.util.ArrayList;
import java.util.List;

public class StudentClass {

    private String name;
    private List<Student> students;

    public StudentClass(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student){
        this.students.add(student);
    }

    public void addStudents(List<Student> students){
        this.students.addAll(students);
    }

    public List<Student> getStudents() {
        return students;
    }
}
