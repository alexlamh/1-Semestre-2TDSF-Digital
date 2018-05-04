package br.com.fiap.ws.bean;

import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.ws.service.FilmeService;
import br.com.fiap.ws.to.Filme;

@ManagedBean
public class FilmeBean {

	private Filme filme;
	
	private FilmeService service;
	
	private FacesMessage msg;

	@PostConstruct
	private void init() {
		filme = new Filme();
		//Temos que inicializar a data
		filme.setDataLancamento(Calendar.getInstance());
		service = new FilmeService();
	}
	
	public List<Filme> getFilmes(){
		try {
			return service.listar();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String excluir(int codigo) {
		try {
			service.remover(codigo);
			msg = new FacesMessage("Removido com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
		//Manter as mensagens ap�s um redirect
		FacesContext.getCurrentInstance().getExternalContext()
			.getFlash().setKeepMessages(true);
		return "lista-filme?faces-redirect=true";
	}
	
	public String salvar() {
		try {
			if (filme.getCodigo() == 0) {
				service.cadastrar(filme);
				msg = new FacesMessage("Cadastrado com sucesso!");
			}else {
				service.atualizar(filme);
				msg = new FacesMessage("Atualizado com sucesso!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro");
		}
		//Adicionar a mensagem para a tela
		FacesContext.getCurrentInstance().addMessage(null, msg);
		//Mantem a mensagem ap�s um redirect
		FacesContext.getCurrentInstance().getExternalContext()
			.getFlash().setKeepMessages(true);
		return "lista-filme?faces-redirect=true";
	}
	
	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

}
