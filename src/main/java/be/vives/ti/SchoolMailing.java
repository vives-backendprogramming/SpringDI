package be.vives.ti;

import be.vives.ti.service.TeacherService;

public class SchoolMailing
{
    public static void main( String[] args )
    {
        TeacherService teacherService = new TeacherService();
        teacherService.sendMessage(1, "Waarom was je afwezig?", 10);
        teacherService.sendMessageToAllStudentsOfClass(1, "3APP", "Afwerken tegen volgende les");
    }
}
