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
		mock.clearArray();
	}

	@Test
	public void testRecuperarConta() {
		ContaCorrente conta = new ContaCorrente("Felipe", "123", "778");
		mock.adicionarConta(conta);

		assertEquals(conta, mock.recuperarConta("778"));

	}
	
	@Test
	public void testPersistirContaDeposito(){
		ContaCorrente conta = new ContaCorrente("Felipe", "123", "778");
		mock.adicionarConta(conta);
				
		conta.depositar(500.0);
		mock.persistirConta(conta);
		
		assertEquals(500.0, mock.recuperarConta("778").saldo(), 0.01);
		
	}
	
	@Test
	public void testPersistirContaSaque(){
		ContaCorrente conta = new ContaCorrente("Felipe", "123", "778");
		mock.adicionarConta(conta);
				
		conta.depositar(500.0);
		mock.persistirConta(conta);
		conta.sacar(200.0);
		mock.persistirConta(conta);
		
		assertEquals(300.0, mock.recuperarConta("778").saldo(), 0.01);
		
	}

}
