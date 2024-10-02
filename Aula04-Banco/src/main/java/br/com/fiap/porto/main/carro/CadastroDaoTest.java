package br.com.fiap.porto.main.carro;

import br.com.fiap.porto.dao.CarroDao;
import br.com.fiap.porto.dao.ConcessionariaDao;
import br.com.fiap.porto.factory.ConnectionFactory;
import br.com.fiap.porto.model.Carro;
import br.com.fiap.porto.model.Concessionaria;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;

public class CadastroDaoTest {

    public static void main(String[] args) {

        try {
            Connection conexao = ConnectionFactory.getConnection();

            //Ler os dados do carro
            String modelo = JOptionPane.showInputDialog("Digite o modelo do carro");
            String placa = JOptionPane.showInputDialog("Digite a placa do carro");
            float motor = Float.parseFloat(JOptionPane.showInputDialog("Digite o motor do carro"));
            boolean automatico = JOptionPane.showConfirmDialog(null, "É automático?",
                    "Automático", JOptionPane.YES_NO_OPTION) == 0;

            String confirmacao = JOptionPane.showInputDialog("Gostaria de adicionar uma concessionária ao Carro?(S/N)");




            //Instanciar o carro
            Carro carro = new Carro(modelo, placa, motor, automatico);

            if (confirmacao.equalsIgnoreCase("s")){
                int id_concess = Integer.parseInt(JOptionPane.showInputDialog("Qual o ID da concessionária: "));

                ConcessionariaDao dao = new ConcessionariaDao(conexao);
                Concessionaria concess = dao.pesquisaId(id_concess);
                carro.setConcessionaria(concess);
            }

            //Instanciar o Dao
            CarroDao carroDao = new CarroDao(conexao);
            //Chamar o método para cadastrar

            carroDao.cadastrar(carro);
            System.out.println("Cadastro realizado!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
