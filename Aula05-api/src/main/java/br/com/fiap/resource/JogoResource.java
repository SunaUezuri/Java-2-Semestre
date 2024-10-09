package br.com.fiap.resource;

import br.com.fiap.dao.JogoDao;
import br.com.fiap.exception.IdNaoEncontradoException;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Jogo;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.sql.SQLException;
import java.util.List;

//http://localhost:8080/jogos

@Path("/jogos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class JogoResource {

    private JogoDao jogoDao;

    public JogoResource() throws Exception{
        jogoDao = new JogoDao(ConnectionFactory.getConnection());
    }

    @POST
    public Response cadastrar(Jogo jogo, @Context UriInfo uriInfo) throws SQLException {
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
    @Path("/{id}")
    public Jogo buscarPorId(@PathParam("id") int id) throws SQLException, IdNaoEncontradoException {
        return jogoDao.pesquisarPorId(id);
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(Jogo jogo, @PathParam("id") int id) throws IdNaoEncontradoException, Exception{
        jogo.setId(id);
        jogoDao.atualizar(jogo);
        return Response.ok().build();
    }


}
