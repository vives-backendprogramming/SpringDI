package be.vives.ti.controller;

import be.vives.ti.model.Student;
import be.vives.ti.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/klas")
public class KlasController {

    private final StudentService studentService;

    public KlasController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{className}")
    public String toonAlleStudentenVanEenKlas(@PathVariable String className, Model model){
        List<Student> allStudentsFromClass = this.studentService.findAllStudentsFromClass(className);
        model.addAttribute("students", allStudentsFromClass);
        model.addAttribute("className", className);
        return "students";
    }

}
