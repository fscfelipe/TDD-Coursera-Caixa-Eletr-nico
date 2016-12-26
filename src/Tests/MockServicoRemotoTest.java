package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Classes.ContaCorrente;
import Classes.MockServicoRemoto;

public class MockServicoRemotoTest {

	MockServicoRemoto mock;

	@Before
	public void setUp() throws Exception {
		mock = new MockServicoRemoto();
	}

	@Test
	public void testRecuperarConta() {
		ContaCorrente conta = new ContaCorrente("Felipe", "123", "778");
		mock.adicionarConta(conta);

		assertEquals(conta, mock.recuperarConta("778"));

	}

}
