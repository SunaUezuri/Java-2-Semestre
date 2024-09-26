package br.com.fiap.porto.dao;

import br.com.fiap.porto.factory.ConnectionFactory;
import br.com.fiap.porto.model.Concessionaria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConcessionariaDao {

    public void cadastrar(Concessionaria concessionaria) throws SQLException, ClassNotFoundException{

        //Criar uma conexão
        Connection conexao = ConnectionFactory.getConnection();

        //Criar o statement
        PreparedStatement stmt = conexao.prepareStatement("insert into t_concessionaria (id_concessionaria, " +
                "nm_concessionaria, nr_cnpj, nr_veiculo_maximo) values (sq_t_concessionaria.nextval, ?, ?, ?)");

        //Setar os valores
        stmt.setString(1, concessionaria.getNome());
        stmt.setString(2, concessionaria.getCnpj());
        stmt.setInt(3, concessionaria.getArmazenamento());

        //Executar o comando SQL
        stmt.executeUpdate();
    }

    //Método para listar as concessionárias registradas no banco
    public List<Concessionaria> listar() throws SQLException, ClassNotFoundException{

        //Criar a conexão com o banco
        Connection conexao = ConnectionFactory.getConnection();

        //Criando o Statement
        Statement stm = conexao.createStatement();

        //Executar o comando SQL
        ResultSet resultSet = stm.executeQuery("select * from t_concessionaria");

        //Criando a lista de concessionárias
        List<Concessionaria> list = new ArrayList<>();

        //Comando para percorrer os registros
        while (resultSet.next()){
            Concessionaria concessionaria = parseConcessionaria(resultSet);

            //Adicionar a concessionária à lista
            list.add(concessionaria);
        }

        return list;
    }

    private Concessionaria parseConcessionaria(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id_concessionaria");
        String nome = resultSet.getString("nm_concessionaria");
        String cnpj = resultSet.getString("nr_cnpj");
        int armazenamento = resultSet.getInt("nr_veiculo_maximo");

        //Criar o objeto Concessionária
        Concessionaria concessionaria = new Concessionaria(id, nome, cnpj, armazenamento);

        return concessionaria;
    }


}
