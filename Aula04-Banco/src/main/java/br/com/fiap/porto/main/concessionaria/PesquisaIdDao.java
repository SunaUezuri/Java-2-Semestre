package br.com.fiap.porto.main.concessionaria;

import br.com.fiap.porto.dao.ConcessionariaDao;
import br.com.fiap.porto.factory.ConnectionFactory;
import br.com.fiap.porto.model.Concessionaria;

import javax.swing.*;
import java.sql.Connection;

public class PesquisaIdDao {

    public static void main(String[] args) {

        try {

            //Pedindo o id da concessionária
            int id = Integer.parseInt(JOptionPane.showInputDialog("Insira o ID da concessionária desejada"));

            //Setando a conexão
            Connection conexao = ConnectionFactory.getConnection();
            ConcessionariaDao dao = new ConcessionariaDao(conexao);

            Concessionaria concess = dao.pesquisaId(id);

            System.out.println("Concessionária: " + concess.getNome());
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
