package projeto.mb;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import projeto.dao.TransportadoraDao;
import projeto.entity.Transportadora;

@ManagedBean
public class TransportadoraMb {
	
private TransportadoraDao transportadoraDao;
	
	private List<Transportadora> transportadoras;
	private Transportadora transportadora;


	public List<Transportadora> getTransportadoras() {
		if(transportadoras == null){
			transportadoras = transportadoraDao.ListarTransportadoras();
		}
		return transportadoras;
	}

	public void setTransportadoras(List<Transportadora> transportadoras) {
		this.transportadoras = transportadoras;
	}

	public Transportadora getTransportadora() {
		return transportadora;
	}

	public void setTransportadora(Transportadora transportadora) {
		this.transportadora = transportadora;
	}
	
 //***************  ações *****************************
	
	@PostConstruct
	public void init(){
		transportadoraDao = new TransportadoraDao();
		transportadora = new Transportadora();
	}
	
	public String salvar(){
		transportadoraDao.atualizarTransportadora(getTransportadora());
		return "transportadoralista";
	}
	
	public String carregarEdicao(String id){
		transportadora = transportadoraDao.buscarPorId(Long.parseLong(id));
		return "transportadora";
	}
	
	public String excluir(String id){
		transportadoraDao.excluirRegistroDeTransportadoraPorId(Long.parseLong(id));
		transportadoras = null;
		return "";
	}
}
