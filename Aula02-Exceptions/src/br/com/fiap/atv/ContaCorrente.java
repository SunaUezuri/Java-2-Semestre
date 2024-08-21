package br.com.fiap.atv;

public class ContaCorrente {

    private double saldo;
    private double limite;

    @Override
    public String toString() {
        return "Saldo disponível: " + saldo +
                "Limite disponível: " + limite;
    }

    public ContaCorrente(){}

    public ContaCorrente(double saldo, double limite) {
        this.saldo = saldo;
        this.limite = limite;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public void sacar(double valor){
        saldo -= valor;
    }

    public void depositar(double valor){
        saldo += valor;
    }
}
