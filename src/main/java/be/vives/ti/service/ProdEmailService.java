package be.vives.ti.service;

import be.vives.ti.model.Student;
import be.vives.ti.model.Teacher;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class ProdEmailService implements IEmailService {

    private TemplateService templateService;
    private JavaMailSender javaMailSender;
    private SimpleMailMessage simpleMailMessage;

    public ProdEmailService(TemplateService templateService, JavaMailSender javaMailSender, SimpleMailMessage simpleMailMessage) {
        this.templateService = templateService;
        this.javaMailSender = javaMailSender;
        this.simpleMailMessage = simpleMailMessage;
    }

    @Override
    public void sendEmail(Teacher teacher, String message, Student student) {
        simpleMailMessage.setTo(student.getEmail());
        simpleMailMessage.setSubject("Bericht van " + teacher.getLastName());
        simpleMailMessage.setText(templateService.getStartTemplate() + "\n" +
                 message + "\n" +
                 templateService.getEndTemplate());

        javaMailSender.send(simpleMailMessage);
    }
}
