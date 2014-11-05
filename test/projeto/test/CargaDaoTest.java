package projeto.test;

import javax.persistence.EntityManager;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import projeto.dao.CargaDao;
import projeto.dao.ClienteDao;
import projeto.dao.TransportadoraDao;
import projeto.entity.Carga;
import projeto.entity.Cliente;
import projeto.entity.Transportadora;
import projeto.util.JpaUtil;

public class CargaDaoTest extends DBUnitTest {
	
//private static EntityManager entityManager;
//	
//	@BeforeClass
//	public static void init(){
//		JpaUtil.iniciarPersistenceUnit();
//		entityManager = JpaUtil.createEntityManager();
//	}
//	
//	@Test
//	public void testEntityManager(){
//		assertNotNull("Gerenciamento de entidade está nulo", entityManager);
//	}
//	
//	@Test
//	public void testCargaDao() {
//		CargaDao dao = new CargaDao(entityManager);
//		assertNotNull("Objeto de acesso a dados do objeto Cliente esta nulo", dao);
//		dao = null;
//	}
//	
//	@Test
//	public void testClienteDao() {
//		ClienteDao dao = new ClienteDao(entityManager);
//		assertNotNull("Objeto de acesso a dados do objeto Contato esta nulo", dao);
//		dao = null;
//	}
//	
//	@Test
//	public void testTranportadoraDao() {
//		TransportadoraDao dao = new TransportadoraDao(entityManager);
//		assertNotNull("Objeto de acesso a dados do objeto Reserva esta nulo", dao);
//		dao = null;
//	}
//	
//	@AfterClass
//	public void close(){
//		entityManager.close();
//		JpaUtil.fecharPersistenceUnit();
//	}

	public CargaDaoTest() {
		super();
	}

	private Carga gravaCarga() {
		begin();
		Carga c = new Carga();
		Transportadora t = new Transportadora();
		Cliente cli = new Cliente();
  	    c.setDescricao("Carga_Teste_1");
		c.setEntrada("1010");
		c.setSaida("1020");
		t.setCnpj("73747474747");
		t.setNome("Express");
		t.setTelefone("34678954");
		cli.setNome("joao");
		cli.setLoja("loja 01");
		cli.setCidade("Maringa");
		Carga carga = getDao().salvar(c);
		close();
		return carga;
	}

	@Test
	public void testGravaCarga() {
		assertNotNull(gravaCarga());
	}

	// private void gravaCarga() {
	// Carga b = new Carga();
	// b.setDescricao("Carga_1");
	// b.setEntrada("Entrada_1");
	// b.setSaida("Saida_1");
	// b.getTransportadora().setCnpj("73747474747");
	//
	// dao.salvar(b);
	//
	// }
	//
	// // @Test
	// // public void testGravaCarga(){
	// // assertNotNull(gravaCarga());
	// // }
	//
	// @Test
	// public void testCargaDao() throws SQLException, Exception {
	// begin();
	// gravaCarga();
	// close();
	//
	// IDataSet dataBase = getConnection().createDataSet();
	// ITable tabelaAtual = dataBase.getTable("carga");
	//
	// IDataSet dataBaseXML = new FlatXmlDataSetBuilder()
	// .build(new FileInputStream(new File("control/carga.xml")));
	// ITable tabelaControle = dataBaseXML.getTable("carga");
	//
	// Assertion.assertEquals(tabelaControle, tabelaAtual);
	//
	// }
	//
}
