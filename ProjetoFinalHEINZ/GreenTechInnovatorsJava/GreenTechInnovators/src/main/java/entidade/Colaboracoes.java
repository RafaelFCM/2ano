package entidade;

import java.time.LocalDate;

public class Colaboracoes {
	private String nome;
	private String email;
	private String telefone;
	private String data_nascimento;
	private int id_protocolo;
	private String data_colaboracao;
	private int nota_avaliacao;
	private String tema_colaboracao;
	private String texto_colaboracao;
	private String cep;
	private String rua;
	private String bairro;
	private String estado;
	private String cidade;
	
	public Colaboracoes(String nome, String email, String telefone, String data_nascimento, int id_protocolo,
			String data_colaboracao, int nota_avaliacao, String tema_colaboracao, String texto_colaboracao,
			String cep, String rua, String bairro, String estado, String cidade) {
		super();
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.data_nascimento = data_nascimento;
		this.id_protocolo = id_protocolo;
		this.data_colaboracao = data_colaboracao;
		this.nota_avaliacao = nota_avaliacao;
		this.tema_colaboracao = tema_colaboracao;
		this.texto_colaboracao = texto_colaboracao;
		this.cep = cep;
		this.rua = rua;
		this.bairro = bairro;
		this.estado = estado;
		this.cidade = cidade;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public int getId_protocolo() {
		return id_protocolo;
	}

	public void setId_protocolo(int id_protocolo) {
		this.id_protocolo = id_protocolo;
	}

	public String getData_colaboracao() {
		return data_colaboracao;
	}

	public void setData_colaboracao(String data_colaboracao) {
		this.data_colaboracao = data_colaboracao;
	}

	public int getNota_avaliacao() {
		return nota_avaliacao;
	}

	public void setNota_avaliacao(int nota_avaliacao) {
		this.nota_avaliacao = nota_avaliacao;
	}

	public String getTema_colaboracao() {
		return tema_colaboracao;
	}

	public void setTema_colaboracao(String tema_colaboracao) {
		this.tema_colaboracao = tema_colaboracao;
	}

	public String getTexto_colaboracao() {
		return texto_colaboracao;
	}

	public void setTexto_colaboracao(String texto_colaboracao) {
		this.texto_colaboracao = texto_colaboracao;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	
	
}
