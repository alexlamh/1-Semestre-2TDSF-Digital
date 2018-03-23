package br.com.fiap.ws.view;

import java.util.Scanner;

import br.com.fiap.ws.service.MedicoService;
import br.com.fiap.ws.to.Medico;

public class BuscaView {

	public static void main(String[] args) {
		//Ler o c�digo
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite o c�digo: ");
		int codigo = sc.nextInt();
		
		try {
			//Chamar o webservice
			MedicoService service = new MedicoService();
			Medico medico = service.buscar(codigo);
			//Exibir os dados do m�dico
			System.out.println(medico.getNome());
			System.out.println(medico.getSalario());
			System.out.println(medico.isPlantonista());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		sc.close();
	}
	
}
