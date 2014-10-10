package projeto.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cliente {

	@Id
	private double codigo_cliente;
	private String cnpj;
	private String endereco;
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getCodigo_cliente() {
		return codigo_cliente;
	}

	public void setCodigo_cliente(double codigo_cliente) {
		this.codigo_cliente = codigo_cliente;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}
