package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="voto",sequenceName="SQ_VOTO",allocationSize=1)
public class Voto {

	@Id
	@GeneratedValue(generator="voto",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	private String candidato;
	
	private Calendar data;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCandidato() {
		return candidato;
	}

	public void setCandidato(String candidato) {
		this.candidato = candidato;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}
}
