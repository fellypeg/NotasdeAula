package NotadeAula2.Questão1;

import java.util.Scanner;

public class SistemaBancario {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Conta conta = null;

        System.out.println("Bem-vindo ao sistema bancário.");
        System.out.println("Selecione o tipo de conta: ");
        System.out.println("1. Conta Corrente");
        System.out.println("2. Conta Poupança");
        int tipoConta = scanner.nextInt();

        scanner.nextLine(); 
        System.out.println("Digite o nome do titular: ");
        String titular = scanner.nextLine();

        if (tipoConta == 1) {
            conta = new ContaCorrente(titular);
        } else if (tipoConta == 2) {
            conta = new ContaPoupanca(titular);
        } else {
            System.out.println("Opção inválida.");
            return;
        }

        int opcao;
        do {
            System.out.println("\nMenu de opções:");
            if (conta instanceof ContaCorrente) {
                System.out.println("1. Depositar");
                System.out.println("2. Sacar");
                System.out.println("3. Usar cheque especial");
                System.out.println("4. Exibir dados da conta");
                System.out.println("5. Sair");
            } else if (conta instanceof ContaPoupanca) {
                System.out.println("1. Depositar");
                System.out.println("2. Sacar");
                System.out.println("3. Calcular rendimento");
                System.out.println("4. Exibir dados da conta");
                System.out.println("5. Sair");
            }

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o valor a ser depositado: ");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 2:
                    System.out.println("Digite o valor a ser sacado: ");
                    double valorSaque = scanner.nextDouble();
                    conta.sacar(valorSaque);
                    break;
                case 3:
                    if (conta instanceof ContaCorrente) {
                        System.out.println("Digite o valor a ser usado do cheque especial: ");
                        double valorChequeEspecial = scanner.nextDouble();
                        ((ContaCorrente) conta).usarChequeEspecial(valorChequeEspecial);
                    } else {
                        System.out.println("Digite a taxa Selic atual (%): ");
                        double taxaSelic = scanner.nextDouble();
                        ((ContaPoupanca) conta).calcularRendimento(taxaSelic);
                    }
                    break;
                case 4:
                    conta.exibirDados();
                    break;
                case 5:
                    System.out.println("Saindo do sistema.");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 5);

        scanner.close();
    }
}
