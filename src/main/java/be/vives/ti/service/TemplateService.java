package be.vives.ti.service;

import java.io.File;

public class TemplateService {

    private File templateFile;

    public TemplateService(File templateFile) {
        this.templateFile = templateFile;
        System.out.println("Template is: " + this.templateFile.getName());
    }

    public String getStartTemplate(){
        return "*******   START   *********";
    }

    public String getEndTemplate(){
        return "*******   END   *********";
    }
}
