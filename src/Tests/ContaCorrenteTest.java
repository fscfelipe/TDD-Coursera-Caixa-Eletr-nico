package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Classes.ContaCorrente;
import Classes.MockServicoRemoto;
import Exceções.SaldoInsuficiente;

public class ContaCorrenteTest {

	
	ContaCorrente conta;
	boolean flag;
	

	@Before
	public void setUp() throws Exception {

		conta = new ContaCorrente("Felipe", "12345", "155XXA");
		boolean flag = false;
	}
	
	@Test(expected= SaldoInsuficiente.class)
	public void testSacarSemSaldo() throws SaldoInsuficiente{
		conta.depositar(500.0);
		conta.sacar(700.0);
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
		try {
			conta.sacar(30.0);
		} catch (SaldoInsuficiente e) {
			fail(e.getMessage());
		}
		assertEquals(20.0, conta.saldo(), 0.0);
	}

}
