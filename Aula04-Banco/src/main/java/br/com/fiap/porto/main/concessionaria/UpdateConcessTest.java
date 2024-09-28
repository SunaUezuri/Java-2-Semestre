package br.com.fiap.porto.main;

import br.com.fiap.porto.dao.ConcessionariaDao;
import br.com.fiap.porto.model.Concessionaria;

import javax.swing.*;

public class UpdateConcessTest {
    public static void main(String[] args) {

        //Criando o DAO da concessionária
        ConcessionariaDao dao = new ConcessionariaDao();

        //Pedindo os dados para o cliente
        int id = Integer.parseInt(JOptionPane.showInputDialog("Insira o id da " +
                "concessionária da qual você deseja atualizar"));
        String nome = JOptionPane.showInputDialog("Insira o novo nome: ");
        String cnpj = JOptionPane.showInputDialog("Insira a nova CNPJ: ");
        int armazenamento = Integer.parseInt(JOptionPane.showInputDialog("Insira a nova capacidade de armazenamento"));

        //Instanciando o objeto concessionaria
        Concessionaria concessionaria = new Concessionaria(id, nome, cnpj, armazenamento);

        //Chamando o método update
        try {

            dao.update(concessionaria);
            System.out.println("Update realizado com sucesso!!!");
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
