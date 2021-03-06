package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Classes.CaixaEletronico;
import Classes.ContaCorrente;
import Classes.MockServicoRemoto;
import Exceções.SaldoInsuficiente;

public class CaixaEletronicoTest {

	CaixaEletronico caixa;
	MockServicoRemoto mock;

	@Before
	public void setUp() throws Exception {
		caixa = new CaixaEletronico();
		mock = new MockServicoRemoto();
		mock.clearArray();
	}

	@Test(expected = SaldoInsuficiente.class)
	public void testSacarSemSaldo() throws SaldoInsuficiente {
		ContaCorrente conta = new ContaCorrente("Felipe", "123", "778");
		caixa.adicionarObservador(mock);
		mock.adicionarConta(conta);
		caixa.logar("Felipppe", "123", "778");

		caixa.depositar(500.0);
		caixa.sacar(700.0);
	}

	@Test
	public void testLogarSucesso() {
		ContaCorrente conta = new ContaCorrente("Felipe", "123", "778");
		caixa.adicionarObservador(mock);
		mock.adicionarConta(conta);

		assertEquals("Usuário Autenticado", caixa.logar("Felipe", "123", "778"));
	}

	@Test
	public void testLogarSemSucesso() {
		ContaCorrente conta = new ContaCorrente("Felipe", "123", "778");
		caixa.adicionarObservador(mock);
		mock.adicionarConta(conta);

		assertEquals("Não foi possível autenticar o usuário", caixa.logar("Felipppe", "123", "778"));
	}

	@Test
	public void testSacarSucesso() {
		ContaCorrente conta = new ContaCorrente("Felipe", "123", "778");
		caixa.adicionarObservador(mock);
		mock.adicionarConta(conta);
		caixa.logar("Felipppe", "123", "778");

		conta.depositar(500.0);
		mock.persistirConta(conta);

		try {
			assertEquals("Retire seu dinheiro", caixa.sacar(300.0));
		} catch (SaldoInsuficiente e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testDepositarSucesso() {
		ContaCorrente conta = new ContaCorrente("Felipe", "123", "778");
		caixa.adicionarObservador(mock);
		mock.adicionarConta(conta);
		caixa.logar("Felipppe", "123", "778");

		conta.depositar(200.0);
		mock.persistirConta(conta);

		assertEquals("Depósito recebido com sucesso", caixa.depositar(200.0));
	}

	@Test
	public void testDepositarSemSucesso() {
		ContaCorrente conta = new ContaCorrente("Felipe", "123", "778");
		caixa.adicionarObservador(mock);
		mock.adicionarConta(conta);
		caixa.logar("Felipppe", "123", "778");

		conta.depositar(200.0);
		mock.persistirConta(conta);

		assertEquals("Valor inválido!", caixa.depositar(-100.0));
	}

	@Test
	public void testSaldo() {
		ContaCorrente conta = new ContaCorrente("Felipe", "123", "778");
		caixa.adicionarObservador(mock);
		mock.adicionarConta(conta);
		caixa.logar("Felipppe", "123", "778");

		conta.depositar(200.0);
		mock.persistirConta(conta);

		assertEquals("O saldo é R$200.0", caixa.saldo());
	}

}
