package br.com.fiap.ws.view;

import java.util.Scanner;

import br.com.fiap.ws.service.MedicoService;
import br.com.fiap.ws.to.Medico;

public class BuscaView {

	public static void main(String[] args) {
		//Ler o código
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite o código: ");
		int codigo = sc.nextInt();
		
		try {
			//Chamar o webservice
			MedicoService service = new MedicoService();
			Medico medico = service.buscar(codigo);
			//Exibir os dados do médico
			System.out.println(medico.getNome());
			System.out.println(medico.getSalario());
			System.out.println(medico.isPlantonista());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		sc.close();
	}
	
}
