package be.vives.ti.service;

import be.vives.ti.model.Student;
import be.vives.ti.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private TemplateService templateService;

    public EmailService(TemplateService templateService) {
        this.templateService = templateService;
    }

    public void sendEmail(Teacher teacher, String message, Student student) {
        StringBuilder sb = new StringBuilder();
        sb.append(templateService.getStartTemplate());
        sb.append("\n");
        sb.append("Send mail");
        sb.append("\n");
        sb.append("From: " +teacher.getFirstName() + " " + teacher.getLastName());
        sb.append("\n");
        sb.append("To: " + student.getFirstName() + " " + student.getLastName());
        sb.append("\n");
        sb.append("Message: " + message);
        sb.append("\n");
        sb.append(templateService.getEndTemplate());
        sb.append("\n");
        String result = sb.toString();
        System.out.println(result);
    }
}
