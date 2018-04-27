package br.com.fiap.ws.bean;

import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.fiap.ws.service.FilmeService;
import br.com.fiap.ws.to.Filme;

@ManagedBean
public class FilmeBean {

	private Filme filme;
	
	private FilmeService service;

	@PostConstruct
	private void init() {
		filme = new Filme();
		filme.setDataLancamento(Calendar.getInstance());
		service = new FilmeService();
	}
	
	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

}
