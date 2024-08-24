package br.com.diap;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EscritaArquivo {

    public static void main(String[] args) {

        try {
            //abrir o arquivo em modo escrito
            FileWriter texto = new FileWriter("exemplo.txt", true);
            PrintWriter arquivoSaida = new PrintWriter(texto);

            //Escrever no arquivo
            arquivoSaida.println("Teste");
            arquivoSaida.println("Conteúdo do arquivo:");
            arquivoSaida.println("Persona 3 reload melhor jogo!!!");

            //Pedir para o usuário escrever algo
            String confirmacao = JOptionPane.showInputDialog("Gostaria de escrever uma mensagem?(S/N)");

            while (confirmacao.equalsIgnoreCase("S")){
                String txt = JOptionPane.showInputDialog("Pode escrever meu nobre: ");

                arquivoSaida.println(txt);

                confirmacao = JOptionPane.showInputDialog("Gostaria de escrever outra mensagem?(S/N)");
            }


            arquivoSaida.close();
            texto.close();
        } catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
}
