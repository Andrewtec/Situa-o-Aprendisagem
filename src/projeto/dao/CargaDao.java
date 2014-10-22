package projeto.dao;
import javax.persistence.Query;

import java.util.List;

import javax.persistence.EntityManager;

import projeto.entity.Carga;
import projeto.util.JpaUtil;

public class CargaDao {
	
	private EntityManager entityManager;
	
	public CargaDao(){
		
		entityManager = JpaUtil.getEntityManager();
	}
	
	public Carga buscarPorId(Long id) {
		return entityManager.find(Carga.class, id);
	}
	
	public void excluirRegistroDeCargaPorId(Long id){
		
		Carga carga=entityManager.getReference(Carga.class,id);
		entityManager.remove(carga);
	}
	
	public List<Carga> ListarCargas(){
		
		Query query=entityManager.createQuery("From Carga",Carga.class);
		
		return query.getResultList();
	}
	
	public void atualizarCarga(Carga carga){
		
		entityManager.merge(carga);
	}

}
