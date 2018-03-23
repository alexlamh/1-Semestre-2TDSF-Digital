package br.com.fiap.ws.view;

import java.util.Scanner;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.fiap.ws.service.MedicoService;
import br.com.fiap.ws.to.Medico;

public class CadastrarView {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//Ler os dados do médico
		Medico medico = new Medico();
		
		System.out.print("Digite o nome: ");
		medico.setNome(sc.next() + sc.nextLine());
		
		System.out.print("Digite o saláio: ");
		medico.setSalario(sc.nextDouble());
		
		System.out.print("Plantonista: ");
		medico.setPlantonista(sc.nextBoolean());
		
		MedicoService service = new MedicoService();
		try {
			service.cadastrar(medico);
			System.out.println("Cadastrado!");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		sc.close();
	}
	
}