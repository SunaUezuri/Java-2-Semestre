package br.com.fiap.porto.main.concessionaria;

import br.com.fiap.porto.dao.ConcessionariaDao;
import br.com.fiap.porto.factory.ConnectionFactory;
import br.com.fiap.porto.model.Concessionaria;

import javax.swing.*;
import java.sql.Connection;


public class CadastroDaoConcess {
    public static void main(String[] args) {


        //Chamando o método de cadastro
        try {
            Connection conexao = ConnectionFactory.getConnection();

            //Criar o dao
            ConcessionariaDao dao = new ConcessionariaDao(conexao);

            //Ler os dados da concessionária
            String nome = JOptionPane.showInputDialog("Insira o nome da concessionária: ");
            String cnpj = JOptionPane.showInputDialog("Insira a CNPJ da empresa: ");
            int armazenamento = Integer.parseInt(JOptionPane.showInputDialog("Insira a capacidade " +
                    "Máxima de armazenamento: "));

            //Instanciando a Concessionária
            Concessionaria concessionaria = new Concessionaria(nome, cnpj, armazenamento);

            dao.cadastrar(concessionaria);
            System.out.println("Concessionária cadastrada com sucesso!");
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
