package entidades;

public class Beneficiario {
    
    private int id;
    private String nome;
    private int idade;
    private long telefone;
    private String endereco;
   
    public Beneficiario(String nome, int idade, long telefone, String endereco, int id){
        this.nome = nome;
        this.idade = idade;
        this.telefone = telefone;
        this.endereco = endereco;
        this.id = id;
    }
    @Override
	public String toString() {
        String aux = "*** detalhes do pedido ***".toUpperCase();
            aux += 
            "\nID: " + id  +
            "\nNome: " + nome + 
            "\nIdade: " + idade + 
            "\nTelefone: " + telefone +
            "\nEndereco: " + endereco +
            "\nPedido em Preparação...";
	    return aux;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getEndereco() {
        return endereco;
    }
    public int getIdade() {
        return idade;
    }
    public long getTelefone() {
        return telefone;
    }
    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }

    
}

