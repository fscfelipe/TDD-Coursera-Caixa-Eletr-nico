package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Classes.ContaCorrente;
import Classes.MockServicoRemoto;

public class ContaCorrenteTest {

	
	ContaCorrente conta;
	boolean flag;
	

	@Before
	public void setUp() throws Exception {

		conta = new ContaCorrente("Felipe", "12345", "155XXA");
		boolean flag = false;
	}

	@Test
	public void testLogar() {
		flag = conta.logar("Felipe", "12345");
		assertTrue(flag == true);
	}
	
	@Test
	public void testSaldo(){
		assertEquals(0.0, conta.saldo(), 0.0);
	}
	
	@Test
	public void testDepositar(){
		conta.depositar(50.0);
		assertEquals(50.0, conta.saldo(), 0.0);
	}
	
	@Test
	public void testSacar(){
		conta.depositar(50.0);
		conta.sacar(30.0);
		assertEquals(20.0, conta.saldo(), 0.0);
	}

}
