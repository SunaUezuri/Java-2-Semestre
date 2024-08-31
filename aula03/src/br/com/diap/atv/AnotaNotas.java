package br.com.diap.atv;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class AnotaNotas {

    public static void main(String[] args) {

        try{
            FileWriter notas = new FileWriter("notas.txt", true);
            PrintWriter imprime = new PrintWriter(notas);

            String confirmacao = JOptionPane.showInputDialog("Gostaria de colocar a nota de um aluno?(S/N)");

            while(confirmacao.equalsIgnoreCase("S")){
                String texto = JOptionPane.showInputDialog("Por favor insira as notas separando elas com uma vírgula");

                imprime.println(texto);
                confirmacao = JOptionPane.showInputDialog("Gostaria de colocar a nota de outro aluno?(S/N)");
            }


            notas.close();
            imprime.close();
        } catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
}
