package be.vives.ti.dao;

import be.vives.ti.model.StudentClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Repository
public class StudentClassDao {
    private DataSource ds;

    public StudentClassDao(DataSource ds) {
        this.ds = ds;
    }

    public StudentClass findByName(String className) {
        // dummy code
        try {
            Connection connection = ds.getConnection();
        } catch (SQLException e) {
            // not a great way to manage exceptions
            e.printStackTrace();
        }

        return new StudentClass(className);
    }
}
