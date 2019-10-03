package be.vives.ti;

import be.vives.ti.service.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SchoolMailing
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        // get Bean by type
        TeacherService teacherService = context.getBean(TeacherService.class);
        teacherService.sendMessage(1, "Waarom was je afwezig?", 10);
        teacherService.sendMessageToAllStudentsOfClass(1, "3APP", "Afwerken tegen volgende les");
    }
}
