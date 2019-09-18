package be.vives.ti.dao;

import be.vives.ti.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Repository
public class TeacherDao {
    private DataSource ds;

    public TeacherDao(DataSource ds) {
        this.ds = ds;
    }

    public Teacher get(int teacherId) {
        // dummy code
        try {
            Connection connection = ds.getConnection();
        } catch (SQLException e) {
            // not a great way to manage exceptions
            e.printStackTrace();
        }

        return new Teacher(teacherId,"John", "Williams");
    }
}
