package projeto.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Transportadora {

	@Id
	private double id_transportadora;
	private String nome;
	private String rota;

	public double getId_transportadora() {
		return id_transportadora;
	}

	public void setId_transportadora(double id_transportadora) {
		this.id_transportadora = id_transportadora;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRota() {
		return rota;
	}

	public void setRota(String rota) {
		this.rota = rota;
	}

}
