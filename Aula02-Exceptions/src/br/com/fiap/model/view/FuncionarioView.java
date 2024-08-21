package br.com.fiap.model.view;

import br.com.fiap.model.exception.MesesInvalidosException;
import br.com.fiap.model.model.Funcionario;

import javax.swing.*;

public class FuncionarioView {

    public static void main(String[] args) {

        //Instanciar um Funcionário com os valores
        Funcionario jorge = new Funcionario("Jorge", 1440.0);

        try{
            //Pedir para o usuário a quantidade de meses trabalhados
            int meses = Integer.parseInt(JOptionPane.showInputDialog("Quantos meses você trabalhou este ano?"));

            //Pedir para o usuário a quantidade de dias nas férias
            int dias = Integer.parseInt(JOptionPane.showInputDialog("Quantos dias você tirou de férias?"));

            //Calcular o PLR do funcionário
            try {
                double plr = jorge.calculaPLD(true, meses);
                JOptionPane.showMessageDialog(null, "Seu PLR é de: " + plr);

                //Calcular as férias do usuário
                double ferias = jorge.calculaFerias(dias);
                JOptionPane.showMessageDialog(null, "Suas férias foram de: " + ferias);

            } catch (MesesInvalidosException e) {
                System.out.println("Tratamento sus...");
            } catch (Exception e){
                System.err.println(e.getMessage());
            }

        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Formato inválido!");
        } finally {
            System.out.println("Obrigado pela preferência!");
        }


    }
}
