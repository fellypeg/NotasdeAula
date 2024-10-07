package NotadeAula2.Questão1;

abstract class Conta {
    protected String titular;
    protected double saldo;

    public Conta(String titular) {
        this.titular = titular;
        this.saldo = 0.0;
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.printf("Depósito realizado. Saldo atual: R$ %.2f%n", saldo);
    }

    public boolean sacar(double valor) {
        if (valor > saldo) {
            System.out.println("Saldo insuficiente.");
            return false;
        }
        saldo -= valor;
        System.out.printf("Saque realizado. Saldo atual: R$ %.2f%n", saldo);
        return true;
    }

    public void exibirDados() {
        System.out.println("Titular: " + titular);
        System.out.printf("Saldo: R$ %.2f%n", saldo);
    }
}

class ContaCorrente extends Conta {
    private final double limiteChequeEspecial = 1000.00;

    public ContaCorrente(String titular) {
        super(titular);
    }

    public boolean usarChequeEspecial(double valor) {
        if (valor > (saldo + limiteChequeEspecial)) {
            System.out.println("Limite de cheque especial excedido.");
            return false;
        }
        saldo -= valor;
        System.out.printf("Cheque especial utilizado. Saldo atual: R$ %.2f%n", saldo);
        return true;
    }
}

class ContaPoupanca extends Conta {
    public ContaPoupanca(String titular) {
        super(titular);
    }

    public void calcularRendimento(double taxaSelic) {
        double rendimento;
        if (taxaSelic > 8.5) {
            rendimento = saldo * 0.005; 
        } else {
            rendimento = saldo * (0.70 * (taxaSelic / 12) / 100); 
        }
        saldo += rendimento;
        System.out.printf("Rendimento aplicado. Saldo atual: R$ %.2f%n", saldo);
    }
}
