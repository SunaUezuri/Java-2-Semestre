package br.com.fiap.porto.main;

import br.com.fiap.porto.dao.ConcessionariaDao;

import javax.swing.*;

public class DeleteConcessDao {
    public static void main(String[] args) {

        //Criando o DAO
        ConcessionariaDao dao = new ConcessionariaDao();

        //Pedindo o ID para o cliente
        int id = Integer.parseInt(JOptionPane.showInputDialog("Insira o id da concessionária que você deseja deletar: "));

        //Chamando o método delete
        try {

            dao.delete(id);
            System.out.println("Concessionária deletada com sucesso!");

        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
