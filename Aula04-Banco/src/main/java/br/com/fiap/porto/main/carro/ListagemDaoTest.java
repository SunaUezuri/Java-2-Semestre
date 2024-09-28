package br.com.fiap.porto.main;

import br.com.fiap.porto.dao.CarroDao;
import br.com.fiap.porto.model.Carro;

import java.util.List;

public class ListagemDaoTest {
    public static void main(String[] args) {
        //Instanciar o DAO
        CarroDao dao = new CarroDao();

        //Chamar o método listar
        try {
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
