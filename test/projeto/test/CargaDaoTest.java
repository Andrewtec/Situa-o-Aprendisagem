package projeto.test;

import org.junit.Test;

import projeto.entity.Carga;
import projeto.entity.Cliente;
import projeto.entity.Transportadora;

public class CargaDaoTest extends DBUnitTest {

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

}
