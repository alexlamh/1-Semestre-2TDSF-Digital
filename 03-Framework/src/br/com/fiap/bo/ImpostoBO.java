package br.com.fiap.bo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ImpostoBO {
	
	private static final Logger log = 
			LoggerFactory.getLogger(ImpostoBO.class);

	public double calcularIPVA(double valor) throws Exception {
		if (valor < 0) {
			log.error("Valor inválido para calculo do IPVA");
			throw new Exception("Valor inválido");			
		}
		log.info("Calculando valor do IPVA: " + valor);
		return valor*0.06;
	}
	
	public double calcularIPTU(double valor) {
		log.trace("Calculado o valor do IPTU: " + valor);
		return valor*0.005;
	}
	
}