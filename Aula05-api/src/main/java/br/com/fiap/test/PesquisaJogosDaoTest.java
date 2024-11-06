package br.com.fiap.test;

import br.com.fiap.dao.JogoDao;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Jogo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PesquisaJogosDaoTest {
    public static void main(String[] args) {

        Connection conexao = null;

        try {
            conexao = ConnectionFactory.getConnection();
            JogoDao dao = new JogoDao(conexao);

            List<Jogo> lista = dao.listarPorDesenvolvedora(4);
            System.out.println("Lista de jogos: " + lista.size());
            for (Jogo jogo : lista){
                System.out.println(jogo);
            }

        } catch (SQLException | ClassNotFoundException e){
            System.err.println(e);
        }
    }
}
