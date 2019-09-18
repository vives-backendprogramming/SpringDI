package be.vives.ti.service;

import be.vives.ti.dao.StudentClassDao;
import be.vives.ti.dao.StudentDao;
import be.vives.ti.dao.TeacherDao;
import be.vives.ti.model.Student;
import be.vives.ti.model.StudentClass;
import be.vives.ti.model.Teacher;

public class TeacherService {

    private TeacherDao teacherDao;
    private StudentService studentService;
    private EmailService emailService;
    private StudentClassService studentClassService;

    public TeacherService() {
        this.teacherDao = new TeacherDao();
        this.studentService = new StudentService();
        this.emailService = new EmailService();
        this.studentClassService = new StudentClassService();
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
