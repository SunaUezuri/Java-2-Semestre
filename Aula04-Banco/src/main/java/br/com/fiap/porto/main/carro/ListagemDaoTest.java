package br.com.fiap.porto.main.carro;

import br.com.fiap.porto.dao.CarroDao;
import br.com.fiap.porto.factory.ConnectionFactory;
import br.com.fiap.porto.model.Carro;

import java.sql.Connection;
import java.util.List;

public class ListagemDaoTest {
    public static void main(String[] args) {


        //Chamar o método listar
        try {
            Connection conexao = ConnectionFactory.getConnection();

            //Instanciar o DAO
            CarroDao dao = new CarroDao(conexao);

            List<Carro> lista = dao.listar();

            //Exibir dados pesquisados
            for (Carro c : lista){
                System.out.println(c.getId() + " " + c.getModelo() + " " + c.getPlaca() + " " + c.getMotor() + " " + c.getModelo());
            }
        } catch (Exception e){
            System.err.println(e.getMessage());
        }


    }
}
