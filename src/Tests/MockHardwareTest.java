package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Classes.ContaCorrente;
import Classes.MockHardware;

public class MockHardwareTest {

	MockHardware mock;
	
	@Before
	public void setUp() throws Exception {
		mock = new MockHardware();
	}

	@Test
	public void testPegarNumeroDaContaCartao() {
		ContaCorrente conta = new ContaCorrente("Felipe", "123", "77865");
		String numero;
		numero = mock.pegarNumeroDaContaCartao(conta);
		
		assertEquals(numero, conta.getNumeroConta());
	}

	@Test
	public void testEntregarDinheiro() {
		ContaCorrente conta = new ContaCorrente("Felipe", "123", "77865");
		conta.depositar(500.0);
		
		
	}

	@Test
	public void testLerEnvelope() {
		fail("Not yet implemented");
	}

}
