package Classes;

import Exceções.FalhaDeFuncionamento;

public class MockHardware implements Hardware {

	String numero;
	
	@Override
	public String pegarNumeroDaContaCartao(ContaCorrente conta) throws FalhaDeFuncionamento {
		numero = conta.getNumeroConta();
		return numero;
	}

	@Override
	public void entregarDinheiro() throws FalhaDeFuncionamento {
		throw new FalhaDeFuncionamento("Falha ao entregar dinheiro");
	}

	@Override
	public void lerEnvelope() throws FalhaDeFuncionamento {
		throw new FalhaDeFuncionamento("Falha ao ler envelope");
		
	}
	

}
