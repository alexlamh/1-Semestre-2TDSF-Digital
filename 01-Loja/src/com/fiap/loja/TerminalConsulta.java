package com.fiap.loja;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fiap.loja.bo.EstoqueBO;
import com.fiap.loja.config.PropertySingleton;
import com.fiap.loja.to.ProdutoTO;

public class TerminalConsulta {

	private static final Logger log = 
			LoggerFactory.getLogger(TerminalConsulta.class);
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		log.trace("Inicializando o sistema");
		int codigo = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		DecimalFormat df = new DecimalFormat("R$ #,###.00");
		EstoqueBO bo = new EstoqueBO();
		String loja = PropertySingleton.getInstance().getProperty("nome");
		do  {
			Calendar hoje = Calendar.getInstance();
			System.out.println(loja+"              "+ sdf.format(hoje.getTime()));
			System.out.println("**********************************");
			System.out.print("C�digo do produto: ");
			codigo = sc.nextInt();
			ProdutoTO produto = bo.buscarProduto(codigo);
			
			if (produto != null) {
				System.out.println(produto.getNome());
				System.out.println("Pre�o: " + df.format(produto.getPreco()));
				System.out.println("Qdt: " + produto.getQuantidade());
			}else if (codigo != 0){
				System.out.println("Produto n�o cadastrado!");
				log.warn("Produto n�o cadastrado " + codigo);
			}else {
				System.out.println("Tchau!");
			}
			
		} while (codigo != 0);
		log.debug("Finalizando a aplica��o");
		sc.close();
	}
	
}




