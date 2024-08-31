package br.com.diap;
import java.io.*;

public class LeituraArquivo {

    public static void main(String[] args) {

        try {
            //Ler o arquico "exemplo.txt"
            FileReader leitor = new FileReader("notas.txt");
            BufferedReader entrada = new BufferedReader(leitor);
            //Exibir o texto

            String linha;

            while((linha = entrada.readLine()) != null){


                String[] vetorTexto = linha.split(",");
                int num1 = Integer.parseInt(vetorTexto[0]);
                int num2 = Integer.parseInt(vetorTexto[1]);

                int resultado = num1 + num2;

                try{
                    FileWriter media = new FileWriter("notaFinal.txt");
                    PrintWriter somaFinal = new PrintWriter(media);

                    somaFinal.println(linha + resultado);

                    media.close();
                    somaFinal.close();

                } catch (IOException e){
                    throw new RuntimeException(e);
                }
            }


            leitor.close();
            entrada.close();
        } catch (IOException e){
            throw new RuntimeException(e);
        }

    }
}
