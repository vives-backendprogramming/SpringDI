package be.vives.ti;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Configuration
@ComponentScan("be.vives")
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
