package projeto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


import projeto.dao.CargaDao;
import projeto.entity.Carga;
import projeto.entity.Cliente;
import projeto.entity.Servico;
import projeto.entity.Transportadora;
import projeto.util.JpaUtil;

public class Main {

	private static EntityManager entityManager;
	private static CargaDao dao;

	public static void main(String[] args) {
		JpaUtil.iniciarPersistenceUnit();

		entityManager = JpaUtil.getEntityManager();
		dao = new CargaDao(entityManager);

		testInserir();
		testAlterar();
		testListar();
		//testExcluir();

	}

	private static void testInserir() {
		Cliente cliente = new Cliente();
		cliente.setCodigo_cliente(1L);
		cliente.setNome("Pedro");
		cliente.setCnpj("88444555444/0000");
		cliente.setEndereco("Rua Patricio Farias - 157 - Florianopolis-SC");

		Transportadora transportadora = new Transportadora();
		transportadora.setId_transportadora(1L);
		transportadora.setNome("Minuano");
		transportadora.setRota("Sul");

		Servico servico = new Servico();
		servico.setCliente(cliente);
		servico.setDescrição("Servico");

		Servico servico2 = new Servico();
		servico2.setCliente(cliente);
		servico2.setDescrição("Servico1");

		ArrayList servicos = new ArrayList<Servico>();
		servicos.add(servico);
		servicos.add(servico2);

		Carga carga = new Carga();
		carga.setData(new Date());
		carga.setDescrição("Serviço de Carga longa");
		carga.setEntrada("1");
		carga.setSaida("2");

		carga.setServicos(servicos);
		carga.setTransportadora(transportadora);

		entityManager.getTransaction().begin();
		dao.registrarCarga(carga);
		entityManager.getTransaction().commit();
	}

	private static void testAlterar() {
		entityManager.getTransaction().begin();
		Carga cargaEditado = entityManager.find(Carga.class, 1L);
		cargaEditado.setDescrição("Serviço de Carga Curta");
		cargaEditado.setEntrada("2");

		entityManager.merge(cargaEditado);
		entityManager.getTransaction().commit();

	}
	
	private static void testListar() {
		Query query = entityManager.createQuery("From Carga", Carga.class);
		List<Carga> carga = query.getResultList();
		
		for(Carga cargas : carga){
			System.out.print("Entrada: " + cargas.getEntrada());
			System.out.println(" - Descrição: " + cargas.getDescrição());
			if(cargas.getId()== 7L){
				for(Servico servicos : cargas.getServicos()){
					System.out.println("servico: " + servicos.getDescrição());
				}
			}
		}
	}
////	private static void testExcluir() {
////		entityManager.getTransaction().begin();
////		Carga carga = entityManager.find(Carga.class, 1L);
////		entityManager.remove(carga);
////		entityManager.getTransaction().commit();
//	}

}
