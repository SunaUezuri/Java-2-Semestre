package br.com.fiap.porto.main;

import br.com.fiap.porto.dao.ConcessionariaDao;
import br.com.fiap.porto.model.Concessionaria;

import java.util.List;

public class ListagemDaoConcess {
    public static void main(String[] args) {

        //Instanciando o Dao
        ConcessionariaDao dao = new ConcessionariaDao();

        //Chamando a listagem
        try {

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
