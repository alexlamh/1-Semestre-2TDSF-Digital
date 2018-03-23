package br.com.fiap.ws.view;

import java.util.List;

import br.com.fiap.ws.service.MedicoService;
import br.com.fiap.ws.to.Medico;

public class ListaView {

	public static void main(String[] args) {
		//Buscar a lista de medicos no web service
		MedicoService service = new MedicoService();
		try {
			List<Medico> lista = service.listar();
			//Exibir os médicos
			for (Medico medico : lista) {
				System.out.println(medico.getNome());
				System.out.println(medico.getSalario());
				System.out.println(medico.isPlantonista());
				System.out.println("**********************");
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
}
