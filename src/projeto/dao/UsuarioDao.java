package projeto.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import projeto.entity.Usuario;
import projeto.util.JpaUtil;


public class UsuarioDao {
	private EntityManager entityManager;

	public UsuarioDao() {
		entityManager = JpaUtil.getEntityManager();
	}

	public Usuario buscarUsuarioPorNome(String nome) {
		Query query = entityManager.createQuery(
				"From Usuario u Where u.nome = :nome", Usuario.class);
		query.setParameter("nome", nome);
		try {
			return (Usuario) query.getSingleResult();
		} catch (Exception exception) {
			return null;
		}
	}
}
