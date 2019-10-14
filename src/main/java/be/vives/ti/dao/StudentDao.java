package be.vives.ti.dao;

import be.vives.ti.model.Student;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
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

        try {
            Connection connection = ds.getConnection();
        } catch (SQLException e) {
            // not a great way to manage exceptions
            e.printStackTrace();
        }

        ArrayList<Student> students = new ArrayList();

        students.add(new Student(20,"Kiara", "Nunez"));
        students.add(new Student(21,"Iyla", "Pickett"));
        students.add(new Student(22,"Oliver", "Chavez"));
        students.add(new Student(23,"Madeleine", "Leigh"));
        students.add(new Student(24,"Libbi", "Cousins"));
        students.add(new Student(25,"Pippa", "Stone"));

        return students;
    }
}
