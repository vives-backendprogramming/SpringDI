package be.vives.ti.controller;

import be.vives.ti.model.Student;
import be.vives.ti.model.Teacher;
import be.vives.ti.service.IEmailService;
import be.vives.ti.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
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

    private final StudentService studentService;
    private final IEmailService emailService;

    @Autowired
    public StudentController(StudentService studentService, IEmailService emailService) {
        this.studentService = studentService;
        this.emailService = emailService;
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
                              Errors errors
                              ) {
        if(errors.hasErrors()){
            return "addstudent";
        }


        studentService.save(student);
        System.out.println(student);
        return "redirect:/klas/"+className;
    }

    @GetMapping("/klas/{className}/mail/{studentId}")
    public String mailStudent(@PathVariable String className,
                              @PathVariable Integer studentId){
        emailService.sendEmail(
                new Teacher(15, "James", "Morrison"),
                "Morgen geen les",
                studentService.get(studentId));
        return "redirect:/klas/"+className;
    }
}
