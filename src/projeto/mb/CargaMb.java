package projeto.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.Query;

import projeto.entity.Carga;
import projeto.util.JpaUtil;

@ManagedBean
public class CargaMb {
	
	private List<Carga> carga;
	private String descricao;
	private String entrada;
	private String saida;
	
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		carga.setDescricao(descricao);
		carga.setEntrada(entrada);
		carga.setSaida(saida);
		

		JpaUtil.getEntityManager().persist(carga);
		return "";
	}

}
