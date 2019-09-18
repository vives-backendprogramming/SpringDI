package be.vives.ti.service;

import be.vives.ti.dao.TeacherDao;
import be.vives.ti.model.Student;
import be.vives.ti.model.StudentClass;
import be.vives.ti.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    private TeacherDao teacherDao;
    private StudentService studentService;
    private EmailService emailService;
    private StudentClassService studentClassService;

    public TeacherService(TeacherDao teacherDao, StudentService studentService, EmailService emailService, StudentClassService studentClassService) {
        this.teacherDao = teacherDao;
        this.studentService = studentService;
        this.emailService = emailService;
        this.studentClassService = studentClassService;
    }

    public void sendMessage(Integer fromTeacherId, String message, Integer toStudentId) {

        Student student = studentService.get(toStudentId);
        Teacher teacher = teacherDao.get(fromTeacherId);

        this.emailService.sendEmail(teacher, message, student);

    }

    public void sendMessageToAllStudentsOfClass(Integer fromTeacherId, String className, String message) {
        Teacher teacher = teacherDao.get(fromTeacherId);

        StudentClass studentClass = studentClassService.findByName(className);

        studentClass.getStudents().stream().forEach(s -> {
            this.emailService.sendEmail(teacher, message, s);
        });
    }
}
