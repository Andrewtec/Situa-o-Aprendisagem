package projeto.mb;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import projeto.dao.CargaDao;
import projeto.dao.ClassificacaoDao;
import projeto.entity.Carga;
import projeto.entity.Classificacao;

@ManagedBean
public class CargaMb {

	private CargaDao cargaDao;

	private List<Carga> cargas;
	private Carga carga;
	
	private List<Classificacao> classificacoes;


	public List<Classificacao> getClassificacoes() {
		if (classificacoes==null){
			ClassificacaoDao classificacoesDao = new ClassificacaoDao();
			classificacoes= classificacoesDao.listarClassificacoes();
		}
		return classificacoes;
	}

	public void setClassificacoes(List<Classificacao> classificacoes) {
		this.classificacoes = classificacoes;
	}

	public List<Carga> getCargas() {
		if (cargas == null) {
			cargas = cargaDao.ListarCargas();
		}
		return cargas;
	}

	public void setCargas(List<Carga> cargas) {
		this.cargas = cargas;
	}

	public Carga getCarga() {
		return carga;
	}

	public void setCarga(Carga carga) {
		this.carga = carga;
	}

	// *************** ações *****************************

	@PostConstruct
	public void init() {
		cargaDao = new CargaDao();
		carga = new Carga();
		carga.setEntrada(new Date());
		carga.setSaida(new Date());
	}

	public String salvar() {
		cargaDao.atualizarCarga(getCarga());
		return "cargalista";
	}

	public String carregarEdicao(String id) {
		carga = cargaDao.buscarPorId(Long.parseLong(id));
		return "carga";
	}

	public String excluir(String id) {
		cargaDao.excluirRegistroDeCargaPorId(Long.parseLong(id));
		cargas = null;
		return "";
	}

}
