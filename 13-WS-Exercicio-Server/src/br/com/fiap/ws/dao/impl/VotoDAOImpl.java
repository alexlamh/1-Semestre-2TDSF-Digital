package br.com.fiap.ws.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Voto;
import br.com.fiap.ws.dao.VotoDAO;

public class VotoDAOImpl 
			extends GenericDAOImpl<Voto, Integer> implements VotoDAO{

	public VotoDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
