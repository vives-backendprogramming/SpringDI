package be.vives.ti.controller;

import be.vives.ti.model.Student;
import be.vives.ti.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/klas/{className}/add")
    public String addNewStudent(Model model,
                                @PathVariable String className){
        model.addAttribute("className", className);
        model.addAttribute("student", new Student());
        return "addstudent";
    }

    @PostMapping(value = "/klas/{className}/savestudent")
    public String saveStudent(@PathVariable String className,
                              @Valid @ModelAttribute("student") Student student,
                              BindingResult bindingResult
                              ) {
        if(bindingResult.hasErrors()){
            return "addstudent";
        }

        studentService.save(student);
        return "redirect:/klas/"+className;
    }
}
