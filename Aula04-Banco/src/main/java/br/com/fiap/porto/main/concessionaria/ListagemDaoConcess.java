package br.com.fiap.porto.main.concessionaria;

import br.com.fiap.porto.dao.ConcessionariaDao;
import br.com.fiap.porto.factory.ConnectionFactory;
import br.com.fiap.porto.model.Concessionaria;

import java.sql.Connection;
import java.util.List;

public class ListagemDaoConcess {
    public static void main(String[] args) {



        //Chamando a listagem
        try {
            Connection conexao = ConnectionFactory.getConnection();

            //Instanciando o Dao
            ConcessionariaDao dao = new ConcessionariaDao(conexao);

            //Criando a lista
            List<Concessionaria> list = dao.listar();

            //Exibindo os dados pesquisados
            for (Concessionaria c : list){
                System.out.println(c.getId() + " " + c.getNome() + " " + c.getCnpj() + " " + c.getArmazenamento());
            }

        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
