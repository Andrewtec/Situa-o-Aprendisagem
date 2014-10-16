package projeto.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;

import projeto.entity.Carga;

@ManagedBean
public class CargaMb {
	
	private List<Carga> carga;
	private String descrição;
	private String entrada;
	private String saida;
	
	
	public String getDescrição() {
		return descrição;
	}
	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}
	public String getEntrada() {
		return entrada;
	}
	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}
	public String getSaida() {
		return saida;
	}
	public void setSaida(String saida) {
		this.saida = saida;
	}
	public List<Carga> getCarga() {
		return carga;
	}
	public void setCarga(List<Carga> carga) {
		this.carga = carga;
	}

}
