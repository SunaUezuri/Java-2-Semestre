package br.com.fiap.atv;

import br.com.fiap.error.ValorInvalido;

import javax.swing.*;

public class ContaCorrenteView {

    public static void main(String[] args) {

        ContaCorrente conta = new ContaCorrente(100, 100);

        try {


            double valorSaque = Double.parseDouble(JOptionPane.showInputDialog("Qual o valor de saque?"));
            conta.sacar(valorSaque);
            System.out.println("Saldo atual: " + conta.getSaldo());
        } catch (ValorInvalido e){
            System.out.println(e.getMessage());
        } catch (Exception e){
            System.out.println("error");
            System.out.println(e.getMessage());
        }

        try {
            double valorDep = Double.parseDouble(JOptionPane.showInputDialog("Qual o valor do depósito?"));
            conta.depositar(valorDep);
            System.out.println("Saldo atual: " + conta.getSaldo());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        try {
            double valorLimite = Double.parseDouble(JOptionPane.showInputDialog("Qual o valor de limite?"));
            conta.setLimite(valorLimite);
            System.out.println("Novo limite: " + conta.getLimite());

        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
