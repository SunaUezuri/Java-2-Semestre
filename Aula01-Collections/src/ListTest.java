import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {

        List<String> compras = new ArrayList<>();
        compras.add("Arroz");
        compras.add("Feijão");
        //compras.add(100); erro de compilação por conta do generics( <> )

        //Exibir a quantidade de elementos da lista
        int tamanho = compras.size();
        System.out.println("itens na lista: " + tamanho);


        //Remover o Feijão da lista
        compras.remove("Feijão");

        //Validar se o macarrão está na lista
        System.out.println("Tem macarrão: " + compras.contains("Macarrão"));

        //criar um array da lista

        String[] vetorCompras = compras.toArray(new String[]{});

        //Adicionar o Macarrão na primeira posição da lista
        compras.add(0, JOptionPane.showInputDialog("Qual item gostaria de adicionar?"));

        //Recuperar o item da compra da posição 0

        System.out.println("Nesta posição está localizado o: " + compras.get(0));

        //Apagar toda a lista de compra
        compras.clear();

        //Adicionar itens Playstation, Xbox, TV, Nintendo

        String confirmacao = JOptionPane.showInputDialog("Gostaria de adicionar um item na lista? (S/N)");

        while (confirmacao.equalsIgnoreCase("S")){
            String produto = JOptionPane.showInputDialog("Que produto gostaria de adicionar?");
            compras.add(produto);
            confirmacao = JOptionPane.showInputDialog("Gostaria de adicionar um item na lista? (S/N)");
        }

        //Substituir o item da posição 0 por Chocolate
        compras.set(0, "Chocolate");

        //Achar o local do chocolate na lista

        System.out.println("Nesta posição está localizado o: " + compras.indexOf("Chocolate"));

        //criar uma sub-lista com os 2 primeiros elementos

        List<String> subLista = compras.subList(0,2);


        System.out.println("Sub-lista feita!");
        for (String item : subLista){
            System.out.println(item);
        }


        //Percorrer a lista e exibir o item da lista
        for (String item : compras){
            System.out.println(item);
        }


    }
}