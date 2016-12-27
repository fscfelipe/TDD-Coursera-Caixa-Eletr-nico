package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Classes.CaixaEletronico;
import Classes.ContaCorrente;
import Classes.MockHardware;
import Classes.MockServicoRemoto;
import Exceções.FalhaDeFuncionamento;
import Exceções.SaldoInsuficiente;

public class MockHardwareTest {

	MockHardware mock;
	
	@Before
	public void setUp() throws Exception {
		mock = new MockHardware();
	}

	@Test
	public void testPegarNumeroDaContaCartao() {
		
		ContaCorrente conta = new ContaCorrente("Felipe", "123", "77865");
		String numero = "";
		try {
			numero = mock.pegarNumeroDaContaCartao(conta);
		} catch (FalhaDeFuncionamento e) {
			fail(e.getMessage());
		}
		
		assertEquals(numero, conta.getNumeroConta());
	}

	@Test(expected=FalhaDeFuncionamento.class)
	public void testEntregarDinheiro() throws FalhaDeFuncionamento {
		CaixaEletronico caixa = new CaixaEletronico();
		MockServicoRemoto servMock = new MockServicoRemoto();
		caixa.adicionarObservador(servMock);
		
		ContaCorrente conta = new ContaCorrente("Felipe", "123", "77865");
		servMock.adicionarConta(conta);
		
		caixa.logar("Felipe", "123", "77865");
		servMock.adicionarConta(conta);
		caixa.depositar(500.0);
		try {
			caixa.sacar(200.0);
		} catch (SaldoInsuficiente e) {
			fail(e.getMessage());
		}
		
		mock.entregarDinheiro();		
	}

	@Test(expected=FalhaDeFuncionamento.class)
	public void testLerEnvelope() throws FalhaDeFuncionamento{
		CaixaEletronico caixa = new CaixaEletronico();
		MockServicoRemoto servMock = new MockServicoRemoto();
		caixa.adicionarObservador(servMock);
		
		ContaCorrente conta = new ContaCorrente("Felipe", "123", "77865");
		servMock.adicionarConta(conta);
		
		caixa.logar("Felipe", "123", "77865");
		servMock.adicionarConta(conta);
		
		mock.lerEnvelope();
	}

}
