package br.com.fiap.jsf.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.ws.service.MedicoService;
import br.com.fiap.ws.to.Medico;

@ManagedBean
public class MedicoBean {

	private Medico medico;
	private MedicoService service;
	
	//Método que é acionado na criação da página
	@PostConstruct
	private void init() {
		medico = new Medico();
		service = new MedicoService();
	}
	
	//Lista de médico para a tabela
	public List<Medico> getMedicos(){
		try {
			return service.listar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Medico>();
	}
	
	public void cadastrar() {
		FacesMessage msg;
		try {
			service.cadastrar(medico);
			msg = new FacesMessage("Cadastrado!");
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro");
		}
		//Adiciona a mensagem para a tela
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	
}
