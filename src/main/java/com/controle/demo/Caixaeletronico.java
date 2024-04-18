package com.controle.demo;

import java.util.Scanner;

public class Caixaeletronico {

    public void Caixaeletronic(Numerodaconta conta) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=--=");
            System.out.println(" CAIXA 24 HORAS ");
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=--=");

            int numeroContaDigitado;
            int tentativasSenha = 0;

            // Loop para verificar se o número da conta é válido
            do {
                System.out.print("Digite o número da conta: ");
                String input = scanner.nextLine();
                if (input.matches("\\d+")) { // Verifica se a entrada é apenas números
                    numeroContaDigitado = Integer.parseInt(input);
                    break; // Sai do loop se a entrada for válida
                } else {
                    System.out.println("Entrada inválida. Digite apenas números para o número da conta.");
                }
            } while (true);

            int numeroContaArmazenado = conta.getnumcartao();

            System.out.println("Por favor, aguarde enquanto validamos seu cartão...");

            try {
                Thread.sleep(3000); // Pausa por 3 segundos
            } catch (InterruptedException e) {
                e.printStackTrace(); // Imprime a pilha de exceções
            }

            // Validação do número da conta
            if (numeroContaDigitado == numeroContaArmazenado) {
                System.out.println("A validação do cartão foi concluída. Próxima informação...");
                System.out.println("Olá " + conta.getnome() + ". Para continuar, aperte qualquer tecla: ");
                System.out.println("Você está no banco " + conta.getTipodeconta() + " na sua conta " + conta.getPouc());

                scanner.nextLine(); // Espera o usuário pressionar qualquer tecla

                // Opções do menu
                System.out.println("Escolha uma opção:");
                System.out.println("1. SACAR");
                System.out.println("2. SALDO");
                System.out.println("3. DEPÓSITO");
                System.out.println("4. TRANSFERÊNCIA");
                
                int opcao;
                while (true) {
                    System.out.print("Digite a opção desejada: ");
                    String opcaoInput = scanner.nextLine();
                    if (opcaoInput.matches("\\d+")) {
                        opcao = Integer.parseInt(opcaoInput);
                        break;
                    } else {
                        System.out.println("Entrada inválida. Por favor, insira um número válido.");
                    }
                }

                // Switch para escolher a operação desejada
                switch (opcao) {
                    case 1:
                        realizarSaque(scanner, conta, tentativasSenha);
                        break;
                    case 2:
                        System.out.println("Saldo disponível: " + conta.getValor());
                        break;
                    case 3:
                        realizarDeposito(scanner, conta);
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

    // Método para realizar saque
    /**
     * @param scanner
     * @param conta
     * @param tentativasSenha
     * @return 
     */
    public String realizarSaque(Scanner scanner, Numerodaconta conta, int tentativasSenha) {
        System.out.println("Escolha um valor de saque:");
        System.out.println("1. $20");
        System.out.println("2. $50");
        System.out.println("3. $100");
        System.out.println("4. Outro valor");
        
        int opcao;
        while (true) {
            System.out.print("Digite a opção desejada: ");
            String opcaoInput = scanner.nextLine();
            if (opcaoInput.matches("\\d+")) {
                opcao = Integer.parseInt(opcaoInput);
                break;
            } else {
                System.out.println("Entrada inválida. Por favor, insira um número válido.");
            }
        }

        int saque = 0;
        switch (opcao) {
            case 1:
                saque = 20;
                break;
            case 2:
                saque = 50;
                break;
            case 3:
                saque = 100;
                break;
            case 4:
                System.out.print("Digite o valor a ser sacado: ");
                while (true) {
                    String saqueInput = scanner.nextLine();
                    if (saqueInput.matches("\\d+")) {
                        saque = Integer.parseInt(saqueInput);
                        break;
                    } else {
                        System.out.println("Entrada inválida. Por favor, insira um número válido.");
                    }
                }
                break;
            default:
                System.out.println("Opção inválida.");
                return null;
        }

        // Verifica a senha e realiza o saque
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
                    return senhaArmazenada;
                }
            }
        }
        return null;
    }

    // Método para realizar depósito
    private void realizarDeposito(Scanner scanner, Numerodaconta conta) {
        System.out.print("Informe o valor a ser depositado: ");
        int deposito;
        while (true) {
            String depositoInput = scanner.nextLine();
            if (depositoInput.matches("\\d+")) {
                deposito = Integer.parseInt(depositoInput);
                break;
            } else {
                System.out.println("Entrada inválida. Por favor, insira um número válido.");
            }
        }

        System.out.println("Digite sua senha: ");
        String senhaDigitada = scanner.nextLine();
        String senhaArmazenada = String.valueOf(conta.getSenha());
        if (senhaDigitada.equals(senhaArmazenada)) {
            conta.setValor(conta.getValor() + deposito);
            System.out.println("Depósito realizado com sucesso. Novo saldo: " + conta.getValor());
        } else {
            System.out.println("Senha incorreta. Operação cancelada.");
        }
    }

    public String realizarSaque(Numerodaconta conta, int valor, String senha) {
        return null;
    }
}
