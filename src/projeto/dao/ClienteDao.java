package projeto.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import projeto.entity.Cliente;
import projeto.util.JpaUtil;

public class ClienteDao {

private EntityManager entityManager;
	
	public ClienteDao(){
		
		entityManager = JpaUtil.getEntityManager();
	}
	
	public Cliente buscarPorId(Long id) {
		return entityManager.find(Cliente.class, id);
	}
	
	public void excluirRegistroDeClientePorId(Long id){
		
		Cliente cliente=entityManager.getReference(Cliente.class,id);
		entityManager.remove(cliente);
	}
	
	public List<Cliente> ListarClientes(){
		
		Query query=entityManager.createQuery("From Cliente",Cliente.class);
		
		return query.getResultList();
	}
	
	public void atualizarCliente(Cliente cliente){
		
		entityManager.merge(cliente);
	}
}
