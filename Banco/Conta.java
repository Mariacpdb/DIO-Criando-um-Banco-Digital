package Banco;

// Classe base Conta
abstract class Conta {
    protected String numero;
    protected double saldo;

    public Conta(String numero) {
        this.numero = numero;
        this.saldo = 0;
    }

    public abstract void depositar(double valor);
    public abstract void sacar(double valor);
    public abstract void transferir(double valor, Conta contaDestino);

    public double getSaldo() {
        return saldo;
    }

    public String getNumero() {
        return numero;
    }
}

// Classe ContaCorrente que herda de Conta
class ContaCorrente extends Conta {
    private static final double TAXA_SAQUE = 1.00; // Taxa para saque

    public ContaCorrente(String numero) {
        super(numero);
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void sacar(double valor) {
        if (valor + TAXA_SAQUE <= saldo) {
            saldo -= (valor + TAXA_SAQUE);
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if (valor + TAXA_SAQUE <= saldo) {
            sacar(valor);
            contaDestino.depositar(valor);
        } else {
            System.out.println("Saldo insuficiente para transferir!");
        }
    }
}

// Classe ContaPoupanca que herda de Conta
class ContaPoupanca extends Conta {
    public ContaPoupanca(String numero) {
        super(numero);
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        sacar(valor);
        contaDestino.depositar(valor);
    }
}

// Classe Banco para gerenciar as contas
class Banco {
    public static void main(String[] args) {
        Conta conta1 = new ContaCorrente("12345");
        Conta conta2 = new ContaPoupanca("67890");

        conta1.depositar(1000);
        conta1.sacar(200);
        conta1.transferir(300, conta2);

        System.out.println("Saldo Conta Corrente: " + conta1.getSaldo());
        System.out.println("Saldo Conta Poupança: " + conta2.getSaldo());
    }
}
