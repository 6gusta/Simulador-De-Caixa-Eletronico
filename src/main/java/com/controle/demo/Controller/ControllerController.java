package com.controle.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    

        @RestController
public class VerificarContaController {

    // Endpoint para verificar a conta
    @GetMapping("/api/verificar-conta")
    public String verificarConta(@RequestParam String numeroConta) {
        // Lógica para verificar se o número da conta é válido
        if ("44072853".equals(numeroConta) || "44028922".equals(numeroConta)) {
            return "Conta válida";
        } else {
            return "Número da conta inválido";
        }
    }
}

    
    


    
}
