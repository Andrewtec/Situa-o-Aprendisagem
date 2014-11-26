package projeto.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.text.ParseException;

import org.junit.Test;

import projeto.entity.Carga;
import projeto.entity.Cliente;
import projeto.entity.Transportadora;

public class CargaDaoTest extends DBUnitTest {

	public CargaDaoTest() {
		super();
	}

	private Carga gravaCarga() throws java.text.ParseException {
		begin();
		Carga c = new Carga();
		Transportadora t = new Transportadora();
		Cliente cli = new Cliente();
		Date date = new Date();
		SimpleDateFormat formatdate = new SimpleDateFormat("dd/MM/yyyy");
		
		try{
			date = formatdate.parse("12/01/2014");
		}
		catch(ParseException e){
			e.printStackTrace();
		}
		c.setDescricao("Carga_Teste_1");
		c.setEntrada(date);
		c.setSaida(date);
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
	public void testGravaCarga() throws ParseException {
		assertNotNull(gravaCarga());
	}

}
