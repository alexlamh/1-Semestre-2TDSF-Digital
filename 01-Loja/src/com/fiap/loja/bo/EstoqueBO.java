package com.fiap.loja.bo;

import com.fiap.loja.to.ProdutoTO;

public class EstoqueBO {

	public ProdutoTO buscarProduto(int codigo) {
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
		}
		return produto;
	}
	
}


