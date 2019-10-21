package be.vives.ti.config;

import org.springframework.context.annotation.*;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;

import java.io.File;
import java.util.Properties;

@Configuration
@ComponentScan(value = "be.vives.ti", excludeFilters={
        @ComponentScan.Filter(Controller.class)})
@PropertySource("classpath:/application.properties")
public class ApplicationConfiguration {

    @Bean
    @Profile("dev")
    public File firstTemplateFile() {
        File f = new File("/devtemplate");
        return f;
    }

    @Bean
    @Profile("!dev")
    public File secondTemplateFile() {
        File f = new File("/template");
        return f;
    }

    public JavaMailSenderImpl mailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();

        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", true);
        prop.put("mail.smtp.ssl.trust", "smtp.sendgrid.net");
        prop.put("mail.smtp.quitwait", false);

        javaMailSender.setJavaMailProperties(prop);

        javaMailSender.setHost("smtp.sendgrid.net");
        javaMailSender.setPort(587);
        javaMailSender.setProtocol("smtp");
        javaMailSender.setUsername("yves.seurynck");
        javaMailSender.setPassword("8F3DFJTZhFN.!wW");

        return javaMailSender;
    }

}
