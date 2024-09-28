package br.com.fiap.porto.main;

import br.com.fiap.porto.dao.CarroDao;
import br.com.fiap.porto.model.Carro;

import javax.swing.*;

public class PesquisarPorIdTest {
    public static void main(String[] args) {

        //Pesquisa um carro pelo ID

        CarroDao dao = new CarroDao();

        int id = Integer.parseInt(JOptionPane.showInputDialog("Insira o ID do carro que deseja ver: "));

        try {
            Carro carro = dao.pesquisarPorId(id);

            //Exibir os dados do carro
            System.out.println(carro.getModelo() + " " + carro.getPlaca());
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
