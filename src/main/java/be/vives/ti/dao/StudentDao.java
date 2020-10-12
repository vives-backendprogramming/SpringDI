package be.vives.ti.dao;

import be.vives.ti.model.Student;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    private DataSource ds;

    public StudentDao(DataSource ds) {
        this.ds = ds;
    }

    public Student get(int studentId) {
        // dummy code
        try {
            Connection connection = ds.getConnection();
        } catch (SQLException e) {
            // not a great way to manage exceptions
            e.printStackTrace();
        }
        Student s1 = new Student(studentId, "Dustin","Tate");
        return s1;
    }


    public List<Student> findAllStudentsFromClass(String className) {
        ArrayList<Student> students = new ArrayList();

        if("3APP".equals(className)){
            students.add(new Student(20,"Kiara", "Nunez"));
            students.add(new Student(21,"Iyla", "Pickett"));
            students.add(new Student(22,"Oliver", "Chavez"));
            students.add(new Student(23,"Madeleine", "Leigh"));
            students.add(new Student(24,"Libbi", "Cousins"));
            students.add(new Student(25,"Pippa", "Stone"));
        }
        else if ("3NET".equals(className)){
            students.add(new Student(10, "Correna","Edmund"));
            students.add(new Student(13, "Wilow","Ronchetti"));
            students.add(new Student(14, "Lani","Million"));
            students.add(new Student(15, "Rahel","Dracey"));
            students.add(new Student(16, "Boyce","VanCassel"));
            students.add(new Student(17, "Patrizius","Potebury"));
            students.add(new Student(18, "Nilson","Spurden"));
            students.add(new Student(19, "Sara","Brunsen"));
        }
        else if("3BIT".equals(className)){
            students.add(new Student(10, "Kimmy","Alecock"));
            students.add(new Student(13, "David","Ronchetti"));
            students.add(new Student(14, "Danyelle","Lockner"));
            students.add(new Student(15, "Ebba","Panchin"));
        }

        return students;
    }
}
