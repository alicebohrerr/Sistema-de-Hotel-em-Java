package hotel.objetos;

public class Quartos {
	
	private Integer numeroQuarto;
	private String tipoQuarto;
	private Double precoDiaria;
	private boolean disponivel;
	
	public Quartos() {
		super();
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public String getTipoQuarto() {
		return tipoQuarto;
	}

	public void setTipoQuarto(String tipoQuarto) {
		this.tipoQuarto = tipoQuarto;
	}

	public Double getPrecoDiaria() {
		return precoDiaria;
	}

	public void setPrecoDiaria(Double precoDiaria) {
		this.precoDiaria = precoDiaria;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	@Override
	public String toString() {
		return "Quartos [numeroQuarto=" + numeroQuarto + ", tipoQuarto=" + tipoQuarto + ", precoDiaria=" + precoDiaria
				+ ", disponivel=" + disponivel + "]";
	}
	
	
	
	

}
