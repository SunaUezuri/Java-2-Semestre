package br.com.fiap.atv;

import br.com.fiap.error.ValorInvalido;

public class ContaCorrente {

    private double saldo;
    private double limite;

    @Override
    public String toString() {
        return "Saldo disponível: " + saldo +
                "Limite disponível: " + limite;
    }

    public ContaCorrente(){}

    public ContaCorrente(double saldo, double limite){
        if (saldo < 0){
            throw new RuntimeException("Valor menor que zero não pode!");
        }

        if (limite < 0){
            throw new RuntimeException("Valor menor que zero não pode!");
        }
        this.saldo = saldo;
        this.limite = limite;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public void sacar(double valor) throws Exception{
        if (valor < 0){
            throw new ValorInvalido();
        }

        if (valor > saldo){
            throw new ValorInvalido(saldo);
        }

        saldo -= valor;
    }

    public void depositar(double valor) throws Exception{

        if (valor < 0){
            throw new ValorInvalido();
        }

        saldo += valor;
    }
}
