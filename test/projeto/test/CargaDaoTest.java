package projeto.test;

import org.junit.Test;

import projeto.entity.Carga;

public class CargaDaoTest extends DBUnitTest {

	public CargaDaoTest() {
		super();
	}

	private Carga gravaCarga() {
		begin();
		Carga c = new Carga();
		c.setDescricao("Cliente_Teste_1");
		c.setEntrada("1010");
		c.setSaida("1020");
		c.getTransportadora().setCnpj("73747474747");
		c.getTransportadora().setNome("Express");
		c.getTransportadora().setTelefone("34678954");
		c.getCliente().setNome("joao");
		c.getCliente().setLoja("loja 01");
		c.getCliente().setCidade("Maringa");
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
