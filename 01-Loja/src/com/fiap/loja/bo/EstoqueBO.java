package com.fiap.loja.bo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fiap.loja.to.ProdutoTO;

/**
 * Classe de negócio que controla o estoque da empresa
 * @author Thiago Yamamoto
 * @version 1.0
 */
public class EstoqueBO {

	private static final Logger log = 
			LoggerFactory.getLogger(EstoqueBO.class);

	/**
	 * Pesquisa um produto em estoque
	 * @param codigo
	 * 	Código do produto
	 * @return Produto
	 */
	public ProdutoTO buscarProduto(int codigo) {
		ProdutoTO produto = null;
		log.trace("Pesquisando produto de código " + codigo);
		switch (codigo) {
		case 401:
			produto = new ProdutoTO(401, 
					"Camiseta Masculina Manga Curta Branca", 40, 10);
			break;
		case 402:
			produto = new ProdutoTO(402, 
					"Camiseta Feminina Manga Longa Rosa", 50, 20);
			break;		
		}
		return produto;
	}
	
}


