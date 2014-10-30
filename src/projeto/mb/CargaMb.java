package projeto.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.persistence.Query;

import projeto.dao.CargaDao;
import projeto.entity.Carga;
import projeto.util.JpaUtil;

@ManagedBean
public class CargaMb {

	private CargaDao cargaDao;

	private List<Carga> cargas;
	private Carga carga;

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
