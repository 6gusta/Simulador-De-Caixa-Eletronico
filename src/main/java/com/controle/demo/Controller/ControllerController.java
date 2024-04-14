package com.controle.demo.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ControllerController {

    @GetMapping("/")
    public String index(Model model) {
        // Lógica do método index
        return "inicio.html";
    }
    
 
    
@RestController
public class VerificarContaController {

    // Endpoint para verificar a conta
    @GetMapping("/api/verificar-conta")
    @ResponseBody
    public ResponseEntity<String> verificarConta(@RequestParam String numeroConta) {
        // Lógica para verificar se o número da conta é válido
        if ("44072853".equals(numeroConta)) {
            String htmlContent = "<h1>Conta válida - Tipo A</h1>";
            return new ResponseEntity<>(htmlContent, HttpStatus.OK);
        } else if ("44028922".equals(numeroConta)) {
            String htmlContent = "<h1>Conta válida - Tipo B</h1>";
            return new ResponseEntity<>(htmlContent, HttpStatus.OK);
        } else {
            String htmlContent = "<h1>Número da conta inválido</h1>";
            return new ResponseEntity<>(htmlContent, HttpStatus.BAD_REQUEST);
        }
    }
}


    
    


    
}
