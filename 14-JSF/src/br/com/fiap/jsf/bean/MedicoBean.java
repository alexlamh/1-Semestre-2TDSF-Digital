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
	
	//Método do clique do botão excluir da listagem
	public void excluir(int codigo) {
		FacesMessage msg;
		try {
			service.remover(codigo);
			msg = new FacesMessage("Removido!");
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro...");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
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
	
	//Método do clique do botão da tela 
	public String salvar() {
		FacesMessage msg;
		try {
			//Verificar se é para cadastrar ou atualizar
			if (medico.getId() == 0) {
				service.cadastrar(medico);
				msg = new FacesMessage("Cadastrado!");
			}else {
				service.atualizar(medico);
				msg = new FacesMessage("Atualizado!");
				FacesContext.getCurrentInstance().addMessage(null, msg);
				return "lista-medicos"; //nome do arquivo da página
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro");
		}
		//Adiciona a mensagem para a tela
		FacesContext.getCurrentInstance().addMessage(null, msg);
		return "medico"; // nome do arquivo da página xhtml
	} 

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	
}
