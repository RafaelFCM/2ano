package Cidades;

public class Cidades {
	private String nome;
	private double porcVacinacao;
	private int numCasos;
	
	public Cidades(String nome, double porcVacinacao, int numCasos) {
		super();
		this.nome = nome;
		this.porcVacinacao = porcVacinacao;
		this.numCasos = numCasos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPorcVacinacao() {
		return porcVacinacao;
	}

	public void setPorcVacinacao(double porcVacinacao) {
		this.porcVacinacao = porcVacinacao;
	}

	public int getNumCasos() {
		return numCasos;
	}

	public void setNumCasos(int numCasos) {
		this.numCasos = numCasos;
	}
	
}
