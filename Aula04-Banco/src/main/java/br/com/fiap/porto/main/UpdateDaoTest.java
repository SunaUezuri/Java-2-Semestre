package br.com.fiap.porto.main;

import br.com.fiap.porto.dao.CarroDao;
import br.com.fiap.porto.model.Carro;

import javax.swing.*;

public class UpdateDaoTest {
    public static void main(String[] args) {
        //Pedir os dados do carro para atualizar o veículo
        int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do carro para a mudança: "));
        String modelo = JOptionPane.showInputDialog("Digite o modelo do carro");
        String placa = JOptionPane.showInputDialog("Digite a placa do carro");
        float motor = Float.parseFloat(JOptionPane.showInputDialog("Digite o motor do carro"));
        boolean automatico = JOptionPane.showConfirmDialog(null, "É automático?",
                "Automático", JOptionPane.YES_NO_OPTION) == 0;

        //Criar o objeto carro
        Carro carro = new Carro(id, modelo, placa, motor, automatico);


        //Instanciar o DAO
        CarroDao dao = new CarroDao();

        //Chamar o método Update
        try {
            dao.atualizar(carro);
            System.out.println("Update realizado com sucesso!");
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
