package be.vives.ti.controller;

import be.vives.ti.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class StudentController {

    @GetMapping("/klas/{className}/add")
    public String addNewStudent(Model model, @PathVariable String className){
        model.addAttribute("className", className);
        model.addAttribute("student", new Student());
        return "addstudent";
    }

    @PostMapping(value = "/klas/{className}/savestudent")
    public String saveStudent(@PathVariable String className,
                              @Valid @ModelAttribute("student") Student student, Errors errors) {
        if(errors.hasErrors()) {
            return "addstudent";
        }
        System.out.println(student);
        return "redirect:/klas/"+className;
    }
}
