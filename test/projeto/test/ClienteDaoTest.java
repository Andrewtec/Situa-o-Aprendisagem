package projeto.test;

import java.io.File;
import java.io.FileInputStream;
import java.sql.SQLException;

import org.dbunit.Assertion;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Test;

import projeto.entity.Cliente;

public class ClienteDaoTest extends DBUnitTest {

	public ClienteDaoTest() {
		super();
	}

	private Cliente gravaCliente() {
		begin();
		Cliente cli = new Cliente();
		cli.setNome("Cliente_Teste_1");
		cli.setLoja("loja");
		cli.setCidade("Floripa");
		Cliente cliente = getDao().salvar(cli);
		close();
		return cliente;
	}

	@Test
	public void testGravaCarga() {
		assertNotNull(gravaCliente());
	}
	

//	@Test
//	public void testClienteDao() throws SQLException, Exception {
//		begin();
//		gravaCliente();
//		close();
//
//		IDataSet dataBase = getConnection().createDataSet();
//		ITable tabelaAtual = dataBase.getTable("cliente");
//
//		IDataSet dataBaseXML = new FlatXmlDataSetBuilder()
//				.build(new FileInputStream(new File("control/cliente.xml")));
//		ITable tabelaControle = dataBaseXML.getTable("cliente");
//
//		Assertion.assertEquals(tabelaControle, tabelaAtual);
//
//	}
}
