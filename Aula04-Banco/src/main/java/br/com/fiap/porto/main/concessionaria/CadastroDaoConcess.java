package br.com.fiap.porto.main;

import br.com.fiap.porto.dao.ConcessionariaDao;
import br.com.fiap.porto.factory.ConnectionFactory;
import br.com.fiap.porto.model.Concessionaria;

import javax.swing.*;


public class CadastroDaoConcess {
    public static void main(String[] args) {
        //Criar o dao
        ConcessionariaDao dao = new ConcessionariaDao();

        //Ler os dados da concessionária
        String nome = JOptionPane.showInputDialog("Insira o nome da concessionária: ");
        String cnpj = JOptionPane.showInputDialog("Insira a CNPJ da empresa: ");
        int armazenamento = Integer.parseInt(JOptionPane.showInputDialog("Insira a capacidade " +
                "Máxima de armazenamento: "));

        //Instanciando a Concessionária
        Concessionaria concessionaria = new Concessionaria(nome, cnpj, armazenamento);

        //Chamando o método de cadastro
        try {
            dao.cadastrar(concessionaria);
            System.out.println("Concessionária cadastrada com sucesso!");
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
