package br.com.diap.atv;

import java.io.*;

public class VoltaNota {
    public static void main(String[] args) {

        try{
            FileReader leitor = new FileReader("notas.txt");
            BufferedReader leitorBuffado = new BufferedReader(leitor);

            String linha;

            FileWriter media = new FileWriter("notasFinal.txt");
            PrintWriter somaFinal = new PrintWriter(media);

            while ((linha = leitorBuffado.readLine()) != null){
                //Separa os valores pelo caractere
                String[] vetor = linha.split(",");

                //Recupera os valores e transforma em int
                int numero1 = Integer.parseInt(vetor[0]);
                int numero2 = Integer.parseInt(vetor[1]);
                int soma = numero1 + numero2;

                somaFinal.println(linha + "," + soma);



                System.out.println(linha + "," + soma);
            }

            leitor.close();
            leitorBuffado.close();
            media.close();
            somaFinal.close();
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
}
