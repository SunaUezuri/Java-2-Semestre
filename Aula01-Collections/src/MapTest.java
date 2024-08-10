import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class MapTest {

    public static void main(String[] args) {
        //Criar um mapeamento de veículos, chave é a placa dos veículos, valor é o modelo do carro
        Map<String, String> veiculo = new HashMap<>();

        //Adicionar 3 veículos no mapeamento
        veiculo.put("559FG", "Ford Ka");
        veiculo.put("P1K4DU", "Fiat Uno");
        veiculo.put("HJ568", "Gol");

        //Recuperar o modelo do veículo pela placa
        String recupera = JOptionPane.showInputDialog("Qual a placa do veículo?");
        System.out.println(veiculo.get(recupera));

        //Adicionar um veiculo em uma placa que já existe
        veiculo.put("559FG", "Civic");
        System.out.println(veiculo.get("559FG"));

        //Exibir key e valor
        for (Map.Entry<String, String> entry : veiculo.entrySet()) {
            System.out.println("Placa: " + entry.getKey() + " Modelo: " + entry.getValue());
        }
    }
}
