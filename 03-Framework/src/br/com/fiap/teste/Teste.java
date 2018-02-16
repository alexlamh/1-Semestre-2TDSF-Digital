package br.com.fiap.teste;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.fiap.bo.ImpostoBO;

public class Teste {

	private static final Logger log = 
				LoggerFactory.getLogger(Teste.class);
	
	public static void main(String[] args) {
		log.debug("Inicializado a aplica��o");
		ImpostoBO bo = new ImpostoBO();
		
		try {
			System.out.println("IPVA: " + bo.calcularIPVA(-30000));
		} catch (Exception e) {
			log.warn("Erro no c�lculo do IPVA");
			System.err.println("Valor inv�lido");
		}
		
		System.out.println("IPTU: " + bo.calcularIPTU(100000));
		
		log.info("Finalizando a aplica��o");
	}
	
}