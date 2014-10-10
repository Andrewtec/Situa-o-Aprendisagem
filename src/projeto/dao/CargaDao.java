package projeto.dao;
import javax.persistence.Query;
import java.util.List;

import javax.persistence.EntityManager;

import projeto.entity.Carga;

public class CargaDao {
	
	private EntityManager entityManager;
	
	public CargaDao(EntityManager entityManager){
		
		this.entityManager=entityManager;
	}
	
	public void registrarCarga(Carga carga){
		
		entityManager.persist(carga);
		
	}
	
	public void excluirRegistroDeCargaPorId(Long id){
		
		Carga carga=entityManager.getReference(Carga.class,1L);
	}
	
	public List<Carga> ListarCargas(){
		
		Query query=entityManager.createQuery("From Carga",Carga.class);
		
		return query.getResultList();
	}
	
	public void atualizarCarga(Carga carga){
		
		entityManager.merge(carga);
	}

}
