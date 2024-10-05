package br.com.fiap.porto.main.carro;

import br.com.fiap.porto.dao.CarroDao;
import br.com.fiap.porto.dao.ConcessionariaDao;
import br.com.fiap.porto.exception.IdNaoEncontradoException;
import br.com.fiap.porto.factory.ConnectionFactory;
import br.com.fiap.porto.model.Carro;
import br.com.fiap.porto.model.Concessionaria;

import javax.swing.*;
import java.sql.Connection;

public class UpdateDaoTest {
    public static void main(String[] args) {


        //Chamar o método Update
        try {
            //Pedir os dados do carro para atualizar o veículo
            int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do carro para a mudança: "));
            String modelo = JOptionPane.showInputDialog("Digite o modelo do carro");
            String placa = JOptionPane.showInputDialog("Digite a placa do carro");
            float motor = Float.parseFloat(JOptionPane.showInputDialog("Digite o motor do carro"));
            boolean automatico = JOptionPane.showConfirmDialog(null, "É automático?",
                    "Automático", JOptionPane.YES_NO_OPTION) == 0;

            boolean mudaConcess = JOptionPane.showConfirmDialog(null, "Gostaria de mudar o id " +
                            "da concessionária?",
                    "Concessionária", JOptionPane.YES_NO_OPTION) == 0;

            //Criar o objeto carro
            Carro carro = new Carro(id, modelo, placa, motor, automatico);

            Connection conexao = ConnectionFactory.getConnection();

            if (mudaConcess){
                int id_concess = Integer.parseInt(JOptionPane.showInputDialog("Qual o novo ID da concessionária: "));

                ConcessionariaDao dao = new ConcessionariaDao(conexao);
                Concessionaria concess = dao.pesquisaId(id_concess);
                carro.setConcessionaria(concess);
            }

            //Instanciar o DAO
            CarroDao dao = new CarroDao(conexao);

            dao.atualizar(carro);
            System.out.println("Update realizado com sucesso!");
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
