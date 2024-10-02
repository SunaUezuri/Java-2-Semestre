package br.com.fiap.porto.main.concessionaria;

import br.com.fiap.porto.dao.ConcessionariaDao;
import br.com.fiap.porto.factory.ConnectionFactory;

import javax.swing.*;
import java.sql.Connection;

public class DeleteConcessDao {
    public static void main(String[] args) {

        //Chamando o método delete
        try {
            Connection conexao = ConnectionFactory.getConnection();

            //Criando o DAO
            ConcessionariaDao dao = new ConcessionariaDao(conexao);

            //Pedindo o ID para o cliente
            int id = Integer.parseInt(JOptionPane.showInputDialog("Insira o id da concessionária que você deseja deletar: "));

            dao.delete(id);
            System.out.println("Concessionária deletada com sucesso!");

        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
