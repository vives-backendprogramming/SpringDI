package be.vives.ti.config;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

import java.io.File;

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



}
