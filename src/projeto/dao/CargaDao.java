package projeto.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


import projeto.entity.Carga;
import projeto.util.JpaUtil;

public class CargaDao {

	private EntityManager entityManager;

	public CargaDao() {
		entityManager = JpaUtil.getEntityManager();
	}

	public CargaDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Carga buscarPorId(Long id) {
		return entityManager.find(Carga.class, id);
	}

	public void excluirRegistroDeCargaPorId(Long id) {

		Carga carga = entityManager.getReference(Carga.class, id);
		entityManager.remove(carga);
	}

	@SuppressWarnings("unchecked")
	public List<Carga> ListarCargas() {

		Query query = entityManager.createQuery("From Carga", Carga.class);

		return query.getResultList();
	}

	public void atualizarCarga(Carga carga) {

		entityManager.merge(carga);
	}

	public Carga salvar(Carga carga) {
		try {
			if (carga.getId() == null) {
				entityManager.persist(carga);
			} else {
				entityManager.merge(carga);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return carga;
	}

}
