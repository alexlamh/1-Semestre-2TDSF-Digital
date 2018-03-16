package br.com.fiap.ws.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_MEDICO")
@SequenceGenerator(name="medico",sequenceName="SQ_T_MEDICO",allocationSize=1)
public class Medico {

	@Id
	@Column(name="cd_medico")
	@GeneratedValue(generator="medico",strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="nm_medico",nullable=false)
	private String nome;
	
	@Column(name="ds_plantonista")
	private boolean plantonista;
	
	@Column(name="vl_salario")
	private double salario;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isPlantonista() {
		return plantonista;
	}

	public void setPlantonista(boolean plantonista) {
		this.plantonista = plantonista;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
}