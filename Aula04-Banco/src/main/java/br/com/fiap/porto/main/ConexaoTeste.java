package br.com.fiap.porto.main;

import br.com.fiap.porto.factory.ConnectionFactory;

import java.sql.Connection;

public class ConexaoTeste {

    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try{
            Connection conexao = connectionFactory.getConnection();
            System.out.println("Conexão  feita!");
            conexao.close();
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
