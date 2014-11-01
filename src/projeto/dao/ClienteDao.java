package projeto.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import projeto.entity.Carga;
import projeto.entity.Cliente;
import projeto.util.JpaUtil;

public class ClienteDao {

	private EntityManager entityManager;

	public ClienteDao() {

		entityManager = JpaUtil.getEntityManager();
	}

	public ClienteDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Cliente buscarPorId(Long id) {
		return entityManager.find(Cliente.class, id);
	}

	public void excluirRegistroDeClientePorId(Long id) {

		Cliente cliente = entityManager.getReference(Cliente.class, id);
		entityManager.remove(cliente);
	}

	public List<Cliente> ListarClientes() {

		Query query = entityManager.createQuery("From Cliente", Cliente.class);

		return query.getResultList();
	}

	public void atualizarCliente(Cliente cliente) {

		entityManager.merge(cliente);
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

	public List<Cliente> listarClientePorNome(String nome) {

		Query query = entityManager.createQuery(
				"From Usuario b Where b.nome = ?", Cliente.class);
		query.setParameter(1, nome);
		return query.getResultList();
	}
}
