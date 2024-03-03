package com.controle.demo;

import java.util.Scanner;

public class Caixaeletronico {

    public void Caixaeletronic(Numerodaconta conta) {
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=--=");
        System.out.println(" CAIXA 24 HORAS ");
        System.out.println("=-=-=-=-=-=-=-==-=--=-======");

        Scanner scanner = new Scanner(System.in);
        int numeroContaDigitado;
        int tentativasSenha = 0; // Variável para controlar as tentativas de senha

        do {
            System.out.print("Digite o número da conta: ");
            String input = scanner.nextLine();
            if (input.matches("\\d+")) { // Verifica se a entrada contém apenas dígitos
                numeroContaDigitado = Integer.parseInt(input);
                break; // Sai do loop se a entrada for um número válido
            } else {
                System.out.println("Entrada inválida. Digite apenas números para o número da conta.");
            }
        } 
        while (true);

        int numeroContaArmazenado = conta.getnumcartao();

        System.out.println("Por favor, aguarde enquanto validamos seu cartão...");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (numeroContaDigitado == numeroContaArmazenado) {
            System.out.println("A validação do cartão foi concluída. Próxima informação...");
            System.out.println("Olá " + conta.getnome() + ". Para continuar, aperte qualquer tecla: ");
            System.out.println("Você está no banco " + conta.getTipodeconta() + " na sua conta " + conta.getPouc());

            String numcolocado = scanner.nextLine();

            System.out.println("Escolha uma opção:");
            System.out.println("1. SACAR");
            System.out.println("2. SALDO");
            int opcao = Integer.parseInt(scanner.nextLine());
            if (opcao == 1) {
                System.out.print("Informe o valor a ser sacado: ");
                int saque = Integer.parseInt(scanner.nextLine());
                System.out.println("Digite sua senha: ");

                while (tentativasSenha < 3) { // Loop para lidar com as tentativas de senha
                    String senhaDigitada = scanner.nextLine(); // Recebe a senha como uma string
                    String senhaArmazenada = String.valueOf(conta.getSenha()); // Converte a senha armazenada para uma string

                    if (senhaDigitada.equals(senhaArmazenada)) {
                        // Senha correta, verificar o saldo
                        if (saque <= conta.getValor()) {
                            // Saldo suficiente, realizar saque
                            conta.setValor(conta.getValor() - saque);
                            System.out.println("Saque realizado com sucesso. Novo saldo: " + conta.getValor());
                        } else {
                            // Saldo insuficiente
                            System.out.println("Saldo insuficiente.");
                        }
                        break; // Sai do loop de tentativa de senha
                    } else {
                        // Senha incorreta
                        System.out.println("Senha inválida.");
                        tentativasSenha++;
                        if (tentativasSenha >= 3) { // Se as tentativas de senha excederem 3, bloqueie o cartão
                            System.out.println("Muitas tentativas inválidas. Seu cartão foi bloqueado.");
                            return; // Sai do método
                        }
                    }
                }
            } else if (opcao == 2) {
                System.out.println("Saldo disponível: " + conta.getValor());
            } else {
                System.out.println("Opção inválida.");
            }
        } else {
            System.out.println("Número da conta inválido.");
        }
    }
}
