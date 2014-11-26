package projeto.test;

import javax.persistence.EntityManager;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import projeto.dao.CargaDao;
import projeto.dao.ClienteDao;
import projeto.dao.TransportadoraDao;
import projeto.util.JpaUtil;

public class CargaDaoTestEntity extends DBUnitTest {

	private static EntityManager entityManager;
	
     @BeforeClass
	public static void init(){
		JpaUtil.iniciarPersistenceUnit();
		entityManager = JpaUtil.createEntityManager();
	}
	
	@Test
	public void testEntityManager(){
		assertNull("Gerenciamento de entidade está nulo", entityManager);
	}
	
	@Test
	public void testCargaDao() {
		CargaDao dao = new CargaDao(entityManager);
		assertNotNull("Objeto de acesso a dados do objeto Cliente esta nulo", dao);
		dao = null;
	}
	
	@Test
	public void testClienteDao() {
		ClienteDao dao = new ClienteDao(entityManager);
		assertNotNull("Objeto de acesso a dados do objeto Contato esta nulo", dao);
		dao = null;
	}
	
	@Test
	public void testTranportadoraDao() {
		TransportadoraDao dao = new TransportadoraDao(entityManager);
		assertNotNull("Objeto de acesso a dados do objeto Reserva esta nulo", dao);
		dao = null;
	}
	
	@AfterClass
	public void close(){
		entityManager.close();
		JpaUtil.fecharPersistenceUnit();
	}
}
