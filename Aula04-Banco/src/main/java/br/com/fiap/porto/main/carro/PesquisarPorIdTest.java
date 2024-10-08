package br.com.fiap.porto.main.carro;

import br.com.fiap.porto.dao.CarroDao;
import br.com.fiap.porto.factory.ConnectionFactory;
import br.com.fiap.porto.model.Carro;

import javax.swing.*;
import java.sql.Connection;

public class PesquisarPorIdTest {
    public static void main(String[] args) {

        //Pesquisa um carro pelo ID



        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Insira o ID do carro que deseja ver: "));

            Connection conexao = ConnectionFactory.getConnection();

            CarroDao dao = new CarroDao(conexao);

            Carro carro = dao.pesquisarPorId(id);

            //Exibir os dados do carro
            System.out.println(carro.getModelo() + " " + carro.getPlaca());
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
