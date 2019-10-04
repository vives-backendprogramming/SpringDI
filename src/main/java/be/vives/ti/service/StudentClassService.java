package be.vives.ti.service;

import be.vives.ti.dao.StudentClassDao;
import be.vives.ti.model.Student;
import be.vives.ti.model.StudentClass;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentClassService {

    private StudentClassDao studentClassDao;
    private StudentService studentService;

    public StudentClassService(StudentClassDao studentClassDao, StudentService studentService) {
        this.studentClassDao = studentClassDao;
        this.studentService = studentService;
    }

    public StudentClass findByName(String className) {
        StudentClass studentClass =  studentClassDao.findByName(className);
        List<Student> students = this.studentService.findAllStudentsFromClass(className);
        studentClass.addStudents(students);
        return studentClass;
    }
}
