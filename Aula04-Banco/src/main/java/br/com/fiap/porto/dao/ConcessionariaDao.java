package br.com.fiap.porto.dao;

import br.com.fiap.porto.exception.IdNaoEncontradoException;
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

    public void update (Concessionaria concessionaria) throws SQLException,
            ClassNotFoundException, IdNaoEncontradoException{

        //Criando a conexão com o banco de dados
        Connection conexao = ConnectionFactory.getConnection();

        //Criando o prepared statement
        PreparedStatement stm = conexao.prepareStatement("update t_concessionaria set nm_concessionaria = ?, " +
                "nr_cnpj = ?, nr_veiculo_maximo = ? where id_concessionaria = ?");

        //Setando os valores no SQL
        stm.setString(1, concessionaria.getNome());
        stm.setString(2, concessionaria.getCnpj());
        stm.setInt(3, concessionaria.getArmazenamento());
        stm.setInt(4, concessionaria.getId());

        //Executar o comando SQL
        int lines = stm.executeUpdate();

        if (lines == 0){
            throw new IdNaoEncontradoException("Concessionária não encontrada.");
        }
    }

    public void delete (int id) throws SQLException, ClassNotFoundException, IdNaoEncontradoException{

        //Criando a conexão com o banco
        Connection conexao = ConnectionFactory.getConnection();

        //Criando o PreparedStatement
        PreparedStatement stm = conexao.prepareStatement("delete from t_concessionaria where id_concessionaria = ?");

        //Setando o valor no SQL
        stm.setInt(1, id);

        //Exxecutando o comando
        int linhas = stm.executeUpdate();

        if (linhas == 0){
            throw new IdNaoEncontradoException("Id não encontrado");
        }
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
