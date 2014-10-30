package projeto.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import projeto.entity.Transportadora;
import projeto.util.JpaUtil;

public class TransportadoraDao {
	
private EntityManager entityManager;
	
	public TransportadoraDao(){
		
		entityManager = JpaUtil.getEntityManager();
	}
	
	public Transportadora buscarPorId(Long id) {
		return entityManager.find(Transportadora.class, id);
	}
	
	public void excluirRegistroDeTransportadoraPorId(Long id){
		
		Transportadora transportadora=entityManager.getReference(Transportadora.class,id);
		entityManager.remove(transportadora);
	}
	
	public List<Transportadora> ListarTransportadoras(){
		
		Query query=entityManager.createQuery("From Transportadora",Transportadora.class);
		
		return query.getResultList();
	}
	
	public void atualizarTransportadora(Transportadora transportadora){
		
		entityManager.merge(transportadora);
	}

}
