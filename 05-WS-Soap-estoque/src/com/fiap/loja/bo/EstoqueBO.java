package com.fiap.loja.bo;

import org.apache.axis2.AxisFault;

import com.fiap.loja.to.ProdutoTO;

/**
 * Classe de negócio que controla o estoque da empresa
 * @author Thiago Yamamoto
 * @version 1.0
 */
public class EstoqueBO {

	/**
	 * Pesquisa um produto em estoque
	 * @param codigo
	 * 	Código do produto
	 * @return Produto
	 * @throws AxisFault 
	 */
	public ProdutoTO buscarProduto(int codigo) throws AxisFault {
		ProdutoTO produto = null;
		switch (codigo) {
		case 401:
			produto = new ProdutoTO(401, 
					"Camiseta Masculina Manga Curta Branca", 40, 10);
			break;
		case 402:
			produto = new ProdutoTO(402, 
					"Camiseta Feminina Manga Longa Rosa", 50, 20);
			break;
		default:
			throw new AxisFault("Produto não cadastrado");
		}
		return produto;
	}
	
}


