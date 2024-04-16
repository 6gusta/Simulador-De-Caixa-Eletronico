package com.controle.demo.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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


@RestController

public class ContaController {

    // Variável para contar o número de tentativas de senha incorreta
//private int tentativasSenha = 0;

    // Método para realizar saque e verificar a senha
    //@PostMapping("/saque")
    //public ResponseEntity<String> sacar(@RequestParam int saque, @RequestParam String senha, @RequestBody Conta conta) {
        // Verifica se o número de tentativas de senha incorreta é menor que 3
       // if (tentativasSenha < 3) {
            // Verifica se a senha fornecida é correta
           // if (conta.getSenha().equals(senha)) {
                // Verifica se o saque é possível com o saldo disponível
               // if (saque <= conta.getValor()) {
                    // Realiza o saque e atualiza o saldo da conta
                   // conta.setValor(conta.getValor() - saque);
                    //return ResponseEntity.ok("Saque realizado com sucesso. Novo saldo: " + conta.getValor());
               // } else {
                    //return ResponseEntity.badRequest().body("Saldo insuficiente.");
//}
           // } else {
                // Senha incorreta, incrementa o contador de tentativas de senha
              //  tentativasSenha++;
               // if (tentativasSenha >= 3) {
               //    return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Muitas tentativas inválidas. Seu cartão foi bloqueado.");
               // }
               // return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Senha incorreta.");
           // }
       // } else {
            // Número de tentativas de senha incorreta excedido
           // return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Muitas tentativas inválidas. Seu cartão foi bloqueado.");
       // }
   // }
}
    


    
}
