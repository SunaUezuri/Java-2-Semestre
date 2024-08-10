import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

public class SetTest {

    public static void main(String[] args) {
        //Criar uma coleção de esportes olímpicos
        Set<String>esportesOlimpicos = new HashSet<>();

        //Adicionar sem o "While"
        esportesOlimpicos.add("Break Dance");
        esportesOlimpicos.add("Futebol");
        esportesOlimpicos.add("Ginastica");
        esportesOlimpicos.add("Golfe");

        //Adicionar 4 esportes olímpicos
        String confirmacao = JOptionPane.showInputDialog("Gostaria de adicionar um esporte?(S/N)");

        while(confirmacao.equalsIgnoreCase("S")){
            String esporte = JOptionPane.showInputDialog("Qual esporte?");
            esportesOlimpicos.add(esporte);
            confirmacao = JOptionPane.showInputDialog("Gostaria de adicionar um esporte?(S/N)");
        }

        //Exibir os esportes:
        for (String item : esportesOlimpicos){
            System.out.println(item);
        }
    }
}
