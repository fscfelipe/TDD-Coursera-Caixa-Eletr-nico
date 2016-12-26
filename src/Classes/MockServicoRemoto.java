package Classes;

import java.util.ArrayList;

public class MockServicoRemoto implements ServicoRemoto {

	ArrayList<ContaCorrente> listaContas = new ArrayList();

	@Override
	public ContaCorrente recuperarConta(String numero) {
		for (ContaCorrente conta : listaContas) {
			if (conta.getNumeroConta() == numero)
				return conta;
		}
		return null;
	}

	@Override
	public void persistirConta() {

	}

	public void adicionarConta(ContaCorrente conta) {
		listaContas.add(conta);
	}

}
