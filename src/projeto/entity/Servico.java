package projeto.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Servico {
	@Id
	@GeneratedValue
	private Long id;
	private String descrição;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Cliente cliente;
	@ManyToOne
	private Carga carga;

	public Carga getCarga() {
		return carga;
	}

	public void setCarga(Carga carga) {
		this.carga = carga;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescrição() {
		return descrição;
	}

	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}

}
