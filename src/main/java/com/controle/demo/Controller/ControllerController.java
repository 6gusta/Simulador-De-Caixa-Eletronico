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


@PostMapping("/api/saque")
public ResponseEntity<String> realizarSaque(@RequestParam String numeroConta, @RequestParam String senha, @RequestParam int valor) {
    // Verifica se os parâmetros são válidos
    if (numeroConta == null || senha == null || valor <= 0) {
        return new ResponseEntity<>("Parâmetros inválidos.", HttpStatus.BAD_REQUEST);
    }

    // Obtenha a conta do banco de dados ou de um serviço externo
    Numerodaconta conta = obterConta(numeroConta);

    // Verifica se a conta foi encontrada
    if (conta == null) {
        return new ResponseEntity<>("Conta não encontrada.", HttpStatus.BAD_REQUEST);
    }

    // Verifica se a senha está correta
    if (!conta.getSenha().equals(senha)) {
        return new ResponseEntity<>("Senha incorreta.", HttpStatus.FORBIDDEN);
    }

    // Verifica se há saldo suficiente
    if (conta.getValor() < valor) {
        return new ResponseEntity<>("Saldo insuficiente.", HttpStatus.PAYMENT_REQUIRED);
    }

    // Realiza o saque e atualiza o saldo da conta
    conta.setValor(conta.getValor() - valor);

    // Salva a conta atualizada no banco de dados ou serviço externo
    atualizarConta(conta);

    // Retorna uma resposta de sucesso com o novo saldo
    String mensagemSucesso = String.format("Saque realizado com sucesso. Novo saldo: %.2f", conta.getValor());
    return new ResponseEntity<>(mensagemSucesso, HttpStatus.OK);
}

// Método para obter a conta com base no número da conta
private Numerodaconta obterConta(String numeroConta) {
    // Implementar a lógica para obter a conta de um banco de dados ou serviço externo
    return null;
}

// Método para atualizar a conta
private void atualizarConta(Numerodaconta conta) {
    // Implementar a lógica para atualizar a conta em um banco de dados ou serviço externo
}


    


    
}
