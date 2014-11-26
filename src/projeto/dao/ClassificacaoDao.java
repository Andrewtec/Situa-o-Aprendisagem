package projeto.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import projeto.entity.Classificacao;
import projeto.util.JpaUtil;

public class ClassificacaoDao {

	private EntityManager entityManager;

	public ClassificacaoDao() {
		entityManager = JpaUtil.getEntityManager();
	}

	public ClassificacaoDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Classificacao buscarPorId(Long id) {
		return entityManager.find(Classificacao.class, id);
	}

	public void excluirRegistroDeClassificacaoPorId(Long id) {

		Classificacao classificacao = entityManager.getReference(
				Classificacao.class, id);
		entityManager.remove(classificacao);
	}

	@SuppressWarnings("unchecked")
	public List<Classificacao> listarClassificacoes() {

		Query query = entityManager.createQuery("From Classificacao",
				Classificacao.class);

		return query.getResultList();
	}

	public void atualizarClassificacao(Classificacao classificacao) {

		entityManager.merge(classificacao);
	}

	public Classificacao salvar(Classificacao classificacao) {
		try {
			if (classificacao.getId() == null) {
				entityManager.persist(classificacao);
			} else {
				entityManager.merge(classificacao);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return classificacao;
	}

}
