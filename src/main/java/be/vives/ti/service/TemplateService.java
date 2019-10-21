package be.vives.ti.service;

import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class TemplateService {

    private File templateFile;

    public TemplateService(File templateFile) {
        System.out.println("Template is " + templateFile.getName());
        this.templateFile = templateFile;
    }

    public String getStartTemplate(){
        return "*******   START   *********";
    }

    public String getEndTemplate(){
        return "*******   END   *********";
    }
}
