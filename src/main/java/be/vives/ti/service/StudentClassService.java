package be.vives.ti.service;

import be.vives.ti.dao.StudentClassDao;
import be.vives.ti.model.Student;
import be.vives.ti.model.StudentClass;

import java.util.List;

public class StudentClassService {

    private StudentClassDao studentClassDao;
    private StudentService studentService;

    public StudentClassService() {
        this.studentClassDao = new StudentClassDao();
        this.studentService = new StudentService();
    }

    public StudentClass findByName(String className) {
        StudentClass studentClass =  studentClassDao.findByName(className);
        List<Student> students = this.studentService.findAllStudentsFromClass(className);
        studentClass.addStudents(students);
        return studentClass;
    }
}
