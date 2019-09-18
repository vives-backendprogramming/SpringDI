package be.vives.ti;

import be.vives.ti.dao.StudentClassDao;
import be.vives.ti.dao.StudentDao;
import be.vives.ti.dao.TeacherDao;
import be.vives.ti.dao.util.MyOwnDataSource;
import be.vives.ti.service.*;
import javax.sql.DataSource;
import java.io.File;

public class SchoolMailing
{
    public static void main( String[] args )
    {
        DataSource ds = new MyOwnDataSource();
        TeacherDao teacherDao = new TeacherDao(ds);
        StudentDao studentDao = new StudentDao(ds);
        File f = new File("/template.xml");
        TemplateService templateService = new TemplateService(f);
        EmailService emailService = new EmailService(templateService);
        StudentClassDao studentClassDao = new StudentClassDao(ds);
        StudentService studentService = new StudentService(studentDao);
        StudentClassService studentClassService = new StudentClassService(studentClassDao, studentService);

        TeacherService teacherService = new TeacherService(teacherDao, studentService, emailService, studentClassService);
        teacherService.sendMessage(1, "Waarom was je afwezig?", 10);
        teacherService.sendMessageToAllStudentsOfClass(1, "3APP", "Afwerken tegen volgende les");
    }
}
