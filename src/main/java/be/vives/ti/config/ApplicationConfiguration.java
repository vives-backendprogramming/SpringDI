package be.vives.ti.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;

import java.io.File;

@Configuration
@ComponentScan(value = "be.vives.ti", excludeFilters={
        @ComponentScan.Filter(Controller.class)})
      //  @ComponentScan.Filter(type= FilterType.ANNOTATION, classes = Controller.class)})
@PropertySource("classpath:/application.properties")
public class ApplicationConfiguration {

    @Bean
    public File firstTemplateFile(){
        File f = new File("/template");
        return f;
    }

    @Bean
    public File secondTemplateFile(){
        File f = new File("/template2");
        return f;
    }
}
