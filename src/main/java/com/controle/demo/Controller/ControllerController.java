package com.controle.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerController {

    @GetMapping("/")
    public String index(Model model) {
        // Lógica do método index
        return "inicio.html";
    }
    
    @GetMapping("/inicio")
    public String inicio(Model model) {
        // Lógica do método inicio
        return "index.html";
    }
    


}
