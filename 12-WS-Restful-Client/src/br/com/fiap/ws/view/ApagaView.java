package br.com.fiap.ws.view;

import java.util.Scanner;

import br.com.fiap.ws.service.MedicoService;

public class ApagaView {

	public static void main(String[] args) {
		//Le o código
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite o código: ");
		int codigo = sc.nextInt();
		
		//Chama o webservice para apagar
		MedicoService service = new MedicoService();
		try {
			service.remover(codigo);
			System.out.println("Removido!");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		sc.close();
	}
	
}
