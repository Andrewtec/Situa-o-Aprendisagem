package projeto.mb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import projeto.dao.CargaDao;
import projeto.entity.Carga;
import projeto.model.Classificacao;

@ManagedBean
public class CargaMb {

	private CargaDao cargaDao;

	private List<Carga> cargas;
	private Carga carga;
	private static List<Classificacao> classificacoes;

	static {
		classificacoes = new ArrayList<Classificacao>();
		classificacoes.add(new Classificacao(1L, "Carga Geral"));
		classificacoes.add(new Classificacao(2L, "Solta"));
		classificacoes.add(new Classificacao(3L, "Unitizada"));
		classificacoes.add(new Classificacao(4L, "Carga a Granel"));
		classificacoes.add(new Classificacao(5L, "Carga Frigorificada"));
		classificacoes.add(new Classificacao(6L, "Carga Perigosa"));
	}

	public List<Carga> getCargas() {
		if (cargas == null) {
			cargas = cargaDao.ListarCargas();
		}
		return cargas;
	}

	public static List<Classificacao> getClassificacoes() {
		return classificacoes;
	}

	public static void setClassificacoes(List<Classificacao> classificacoes) {
		CargaMb.classificacoes = classificacoes;
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
