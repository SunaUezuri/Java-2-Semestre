package br.com.fiap.porto.main.carro;

import br.com.fiap.porto.dao.CarroDao;
import br.com.fiap.porto.factory.ConnectionFactory;

import javax.swing.*;
import java.sql.Connection;

public class DeleteDaoTest {
    public static void main(String[] args) {


        //Chamar o método Delete
        try {
            Connection conexao = ConnectionFactory.getConnection();

            //Pegar o id que deseja
            int id = Integer.parseInt(JOptionPane.showInputDialog("Insira o id do veículo do qual você deseja deletar"));

            //Instanciar o DAO
            CarroDao dao = new CarroDao(conexao);

            dao.remover(id);
            System.out.println("Carro deletado com sucesso!");
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
