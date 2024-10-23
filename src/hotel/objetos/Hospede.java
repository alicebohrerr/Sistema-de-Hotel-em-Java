package hotel.objetos;

public class Hospede {
	
	private String nome;
	private String cpf;
	
	public Hospede(String nome, String cpf) {
		super();
		this.nome = nome;
		this.cpf = cpf;
	}

	public Hospede() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "Hospede [nome=" + nome + ", cpf=" + cpf + "]";
	}
	
	
	
	
	
	

}
