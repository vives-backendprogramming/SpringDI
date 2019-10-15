package be.vives.ti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.Random;

@Controller
public class WelcomeController {

    @GetMapping()
    public String welcome(Model model) {
        String sysdate = new Date().toString();
        int version = new Random().nextInt(10) + 1;

        model.addAttribute("sysdate", sysdate);
        model.addAttribute("version", version);

        return "index";
    }

}
