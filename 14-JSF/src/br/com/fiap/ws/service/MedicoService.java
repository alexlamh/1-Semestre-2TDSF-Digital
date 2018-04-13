package br.com.fiap.ws.service;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.fiap.ws.to.Medico;

public class MedicoService {
	
	private Client client;
	
	public MedicoService() {
		client = Client.create();
	}
	
	//Constante com a URL
	private static final String URL = "http://localhost:8080/11-WS-Restful-Server/rest/medico";
	
	public void remover(int codigo) throws Exception {
		WebResource resource = client.resource(URL)
				.path(String.valueOf(codigo));
		ClientResponse response = 
				resource.delete(ClientResponse.class);
		
		if (response.getStatus() != 204) {
			throw new Exception("Erro " + response.getStatus());
		}
	}
	
	public void atualizar(Medico medico) throws Exception {
		WebResource resource = client.resource(URL)
				//Código do médico que será atualizado
				.path(String.valueOf(medico.getId()));
		
		ClientResponse response = resource
				.type(MediaType.APPLICATION_JSON)
				.put(ClientResponse.class,medico);
		
		if (response.getStatus() != 200) {
			throw new Exception("Erro " + response.getStatus());
		}
			
	}

	public List<Medico> listar() throws Exception{
		WebResource resource = client.resource(URL);
		ClientResponse response = resource
				.accept(MediaType.APPLICATION_JSON)
				.get(ClientResponse.class);
		
		if (response.getStatus() != 200) {
			throw new Exception("Erro " + response.getStatus());
		}
		Medico[] array = response.getEntity(Medico[].class);
		//Converte o vetor em lista
		return Arrays.asList(array);
	}
	
	public Medico buscar(int codigo) throws Exception {
		WebResource resource = client.resource(URL)
							//Adiciona o código na URL
							.path(String.valueOf(codigo));
		//Chama o Webservice
		ClientResponse response = resource
				.accept(MediaType.APPLICATION_JSON)
				.get(ClientResponse.class);
		
		//Valida o Status 200 OK
		if (response.getStatus() != 200) {
			throw new Exception("Erro " + response.getStatus());
		}
		//Retorna o Médico
		return response.getEntity(Medico.class);
	}
	
	public void cadastrar(Medico medico) throws Exception {
		// Cadastrar o médico através do webservice
		WebResource resource = client.resource(URL);

		ClientResponse response = resource
				// Envia JSON
				.type(MediaType.APPLICATION_JSON)
				.post(ClientResponse.class, medico);

		// Validar o HTTP Status Code 201 Created
		if (response.getStatus() != 201) {
			throw new Exception("Erro " + response.getStatus());
		}
	}

}
