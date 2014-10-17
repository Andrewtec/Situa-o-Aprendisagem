package projeto.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.Query;

import projeto.entity.Carga;
import projeto.util.JpaUtil;

@ManagedBean
public class CargaMb {
	
	private List<Carga> carga;
	private String descri��o;
	private String entrada;
	private String saida;
	
	
	public String getDescri��o() {
		return descri��o;
	}
	public void setDescri��o(String descri��o) {
		this.descri��o = descri��o;
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
		if(carga == null){
			Query query = JpaUtil.getEntityManager()
					.createQuery("From Canal", Carga.class);
			carga = query.getResultList();
		}
		return carga;
	}
	public void setCarga(List<Carga> carga) {
		this.carga = carga;
	}
	
	public String salvar(){
		Carga carga = new Carga();
		carga.setDescri��o(descri��o);
		carga.setEntrada(entrada);
		carga.setSaida(saida);
		

		JpaUtil.getEntityManager().persist(carga);
		return "";
	}

}
