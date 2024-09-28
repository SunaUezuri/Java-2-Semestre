package br.com.fiap.porto.main;

import br.com.fiap.porto.dao.CarroDao;

import javax.swing.*;

public class DeleteDaoTest {
    public static void main(String[] args) {
        //Pegar o id que deseja
        int id = Integer.parseInt(JOptionPane.showInputDialog("Insira o id do veículo do qual você deseja deletar"));

        //Instanciar o DAO
        CarroDao dao = new CarroDao();

        //Chamar o método Delete
        try {
            dao.remover(id);
            System.out.println("Carro deletado com sucesso!");
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
