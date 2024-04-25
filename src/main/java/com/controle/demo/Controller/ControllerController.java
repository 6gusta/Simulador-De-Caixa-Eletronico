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

import com.controle.demo.Numerodaconta;

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
public class SaqueController {

    @PostMapping("/api/saque")
    public ResponseEntity<String> realizarSaque(@RequestParam String senha, @RequestParam int valor) {
        // Verifica se os parâmetros são válidos
        if (senha == null || senha.isEmpty() || valor <= 0) {
            return new ResponseEntity<>("Parâmetros inválidos.", HttpStatus.BAD_REQUEST);
        }

        // Verifica se a senha está correta
        if (!"0376".equals(senha)) { // Substitua pela lógica real de verificação de senha
            return new ResponseEntity<>("Senha incorreta.", HttpStatus.FORBIDDEN);
        }

        // Aqui você pode implementar a lógica para realizar o saque na conta do usuário
        // Isso incluirá a verificação do saldo, a atualização do saldo após o saque, etc.

        // Simulação de sucesso
        double novoSaldo = 1000 - valor; // Substitua pelo novo saldo após o saque
        String mensagemSucesso = String.format("Saque de R$ %d realizado com sucesso. Novo saldo: R$ %.2f", valor, novoSaldo);
        return ResponseEntity.ok(mensagemSucesso);
    }
}

///@RestController
//public class saldoController{
    //@GetMapping("/api/saldo")
    //public ResponseEntity<Double> consultarSaldo() {
      //  if (conta != null) {
          //  double saldo = conta.getSaldo();
           // return ResponseEntity.ok(saldo);
       // } else {
            // Se a conta não estiver disponível, retorna um erro 404 (Not Found)
          //  return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
      //  }
   // }
//}///





    


    
}
