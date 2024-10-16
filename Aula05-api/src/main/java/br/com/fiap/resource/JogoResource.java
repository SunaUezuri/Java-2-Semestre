package br.com.fiap.resource;

import br.com.fiap.dao.JogoDao;
import br.com.fiap.dto.jogo.CadastroJogoDto;
import br.com.fiap.dto.jogo.DetalhesJogoDto;
import br.com.fiap.exception.IdNaoEncontradoException;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Jogo;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import org.modelmapper.ModelMapper;

import java.sql.SQLException;
import java.util.List;

//http://localhost:8080/jogos

@Path("/jogos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class JogoResource {

    private JogoDao jogoDao;
    private ModelMapper modelMapper;

    public JogoResource() throws Exception{
        jogoDao = new JogoDao(ConnectionFactory.getConnection());
        modelMapper = new ModelMapper();
    }

    @POST
    public Response cadastrar(CadastroJogoDto dto, @Context UriInfo uriInfo) throws SQLException {
        Jogo jogo = modelMapper.map(dto, Jogo.class);
        jogoDao.cadastrar(jogo);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(String.valueOf(jogo.getId())); //Constroi a URI para acessar o jogo cadastrado
        return Response.created(builder.build()).build();
    }

    @GET
    public List<Jogo> buscar() throws SQLException{
        return jogoDao.listar();
    }

    @GET
    @Path("pesquisa") //http://localhost:8080/jogos/pesquisa?nome=xxx
    public List<Jogo> listarPorNome(@DefaultValue("a") @QueryParam("nome") String nome) throws SQLException {
        return jogoDao.listarPorNome(nome);
    }

    @GET
    @Path("/{id}")
    public DetalhesJogoDto buscarPorId(@PathParam("id") int id) throws SQLException, IdNaoEncontradoException {
        Jogo jogo = modelMapper.map(DetalhesJogoDto.class, Jogo.class);
        return jogoDao.pesquisarPorId(id);
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(Jogo jogo, @PathParam("id") int id) throws IdNaoEncontradoException, Exception{
        jogo.setId(id);
        jogoDao.atualizar(jogo);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response remover(@PathParam("id") int id) throws IdNaoEncontradoException, SQLException{
        jogoDao.remover(id);
        return Response.noContent().build();
    }

    @PATCH //Realizar a atualização parcial do objeto
    @Path("/{id}")
    public Response atualizarParcial(@PathParam("id") int id, Jogo jogo) throws IdNaoEncontradoException, SQLException {
        //Pesquisar o jogo no banco de dados
        Jogo jogoBanco = jogoDao.pesquisarPorId(id);
        //Verifica se existe valor no objeto recebido, eu seto o novo valor no objeto do banco
        if (jogo.getNome() != null)
            jogoBanco.setNome(jogo.getNome());
        if (jogo.getClassificacao() != null)
            jogoBanco.setClassificacao(jogo.getClassificacao());
        if (jogo.getDataLancamento() != null)
            jogoBanco.setDataLancamento(jogo.getDataLancamento());
        jogoDao.atualizar(jogoBanco);
        return Response.ok().build();
    }

}
