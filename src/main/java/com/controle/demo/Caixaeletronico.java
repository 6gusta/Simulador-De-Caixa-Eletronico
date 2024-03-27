package com.controle.demo;

import java.util.Scanner;

public class Caixaeletronico {

    public void Caixaeletronic(Numerodaconta conta) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=--=");
            System.out.println(" CAIXA 24 HORAS ");
            System.out.println("=-=-=-=-=-=-=-==-=--=-======");

            int numeroContaDigitado;
            int tentativasSenha = 0; 

            do {
                System.out.print("Digite o número da conta: ");
                String input = scanner.nextLine();
                if (input.matches("\\d+")) { 
                    numeroContaDigitado = Integer.parseInt(input);
                    break; 
                } else {
                    System.out.println("Entrada inválida. Digite apenas números para o número da conta.");
                }
            } while (true);

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
                System.out.println("3. DEPÓSITO");
                System.out.println("4. TRANSFERÊNCIA");
                int opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1:
                        System.out.print("Informe o valor a ser sacado: ");
                        int saque = Integer.parseInt(scanner.nextLine());
                        System.out.println("Digite sua senha: ");

                        while (tentativasSenha < 3) { 
                            String senhaDigitada = scanner.nextLine(); 
                            String senhaArmazenada = String.valueOf(conta.getSenha()); 

                            if (senhaDigitada.equals(senhaArmazenada)) {
                                if (saque <= conta.getValor()) {
                                    conta.setValor(conta.getValor() - saque);
                                    System.out.println("Saque realizado com sucesso. Novo saldo: " + conta.getValor());
                                } else {
                                    System.out.println("Saldo insuficiente.");
                                }
                                break; 
                            } else {
                                System.out.println("Senha incorreta.");
                                tentativasSenha++;
                                if (tentativasSenha >= 3) { 
                                    System.out.println("Muitas tentativas inválidas. Seu cartão foi bloqueado.");
                                    return; 
                                }
                            }
                        }
                        break;

                    case 2:
                        System.out.println("Saldo disponível: " + conta.getValor());
                        break;

                    case 3:
                        System.out.print("Informe o valor a ser depositado: ");
                        int deposito = Integer.parseInt(scanner.nextLine());
                        System.out.println("Digite sua senha: ");
                        String senhaDigitada = scanner.nextLine();
                        String senhaArmazenada = String.valueOf(conta.getSenha());
                        if (senhaDigitada.equals(senhaArmazenada)) {
                            conta.setValor(conta.getValor() + deposito);
                            System.out.println("Depósito realizado com sucesso. Novo saldo: " + conta.getValor());
                        } else {
                            System.out.println("Senha incorreta. Operação cancelada.");
                        }
                        break;

                    case 4:
                        System.out.println("No momento essa opção se encontra indisponível.");
                        break;

                    default:
                        System.out.println("Opção inválida.");
                        break;
                }

            } else {
                System.out.println("Número da conta inválido.");
            }

            System.out.println("Deseja realizar outra operação? (S/N)");
            String continuar = scanner.nextLine();
            if (!continuar.equalsIgnoreCase("S")) {
                break;
            }
        }
    }
}
