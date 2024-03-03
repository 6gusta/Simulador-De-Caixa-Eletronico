package com.controle.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("mensagem", "Olá, mundo!");
        return "index.html"; // Isso corresponde ao arquivo "src/main/resources/templates/index.html"
    }
}
