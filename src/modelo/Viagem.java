package modelo;

public class Viagem {
	
	private int id_viagem;
	private String nome_viagem;
	private Double valor_viagem;
	

public int getId_viagem() {
		return id_viagem;
	}

	public void setId_viagem(int id_viagem) {
		this.id_viagem = id_viagem;
	}

	public String getNome_viagem() {
		return nome_viagem;
	}

	public void setNome_viagem(String nome_viagem) {
		this.nome_viagem = nome_viagem;
	}

	public Double getValor_viagem() {
		return valor_viagem;
	}

	public void setValor_viagem(Double valor_viagem) {
		this.valor_viagem = valor_viagem;
	}

public Viagem () {
	 
 }

public Viagem(int id_viagem, String nome_viagem, Double valor_viagem) {
	super();
	this.id_viagem = id_viagem;
	this.nome_viagem = nome_viagem;
	this.valor_viagem = valor_viagem;
}
}
