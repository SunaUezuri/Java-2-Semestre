package br.com.fiap.porto.dao;

import br.com.fiap.porto.factory.ConnectionFactory;
import br.com.fiap.porto.model.Concessionaria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ConcessionariaDao {

    public void cadastrar(Concessionaria concessionaria) throws SQLException, ClassNotFoundException{

        //Criar uma conexão
        Connection conexao = ConnectionFactory.getConnection();

        //Criar o statement
        PreparedStatement stm = conexao.prepareStatement("insert into t_concessionaria (id_concessionaria, " +
                "nm_concessionaria, nr_cnpj, nr_veiculo_maximo) values (sq_t_concessionaria.nextval, ?, ?, ?)");

        //Setar os valores
        stm.setString(1, concessionaria.getNome());
        stm.setString(2, concessionaria.getCnpj());
        stm.setInt(3, concessionaria.getArmazenamento());

        //Executar o comando SQL
        stm.executeUpdate();
    }


}
