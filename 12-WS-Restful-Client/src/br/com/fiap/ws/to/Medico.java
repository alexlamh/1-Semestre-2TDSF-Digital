package br.com.fiap.ws.to;

public class Medico {

	private int id;
	
	private String nome;
	
	private boolean plantonista;
	
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