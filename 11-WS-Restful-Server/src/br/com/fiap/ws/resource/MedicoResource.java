package br.com.fiap.ws.resource;

import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.ws.dao.MedicoDAO;
import br.com.fiap.ws.dao.impl.MedicoDAOImpl;
import br.com.fiap.ws.entity.Medico;
import br.com.fiap.ws.exception.CommitException;
import br.com.fiap.ws.singleton.EntityManagerFactorySingleton;

@Path("/medico")
public class MedicoResource {

	private MedicoDAO dao;
	
	public MedicoResource() {
		EntityManager em = 
			EntityManagerFactorySingleton
			.getInstance().createEntityManager();
		dao = new MedicoDAOImpl(em);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Medico> listar(){
		return dao.listar();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Medico buscar(@PathParam("id") int codigo) {
		return dao.buscar(codigo);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Medico medico, 
			@Context UriInfo url) {
		try {
			dao.cadastrar(medico);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
		//Criar a URL que exibe o medico cadastrado
		UriBuilder b = url.getAbsolutePathBuilder();
		b.path(String.valueOf(medico.getId()));
		return Response.created(b.build()).build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response atualizar(Medico medico, 
			@PathParam("id") int id) {
		try {
			medico.setId(id);
			dao.atualizar(medico);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
		return Response.ok().build();
	}
	
	@DELETE
	@Path("{id}")
	public void apagar(@PathParam("id") int id) {
		try { 
			dao.remover(id);
			dao.commit();
		}catch(Exception e) {
			e.printStackTrace();
			throw new 
				WebApplicationException(
						Status.INTERNAL_SERVER_ERROR);
		}
	}
	
}







