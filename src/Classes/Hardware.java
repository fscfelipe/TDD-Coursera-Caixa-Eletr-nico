package Classes;

import Exceções.FalhaDeFuncionamento;

public interface Hardware {
	public String pegarNumeroDaContaCartao(ContaCorrente conta) throws FalhaDeFuncionamento;
	public void entregarDinheiro() throws FalhaDeFuncionamento;
	public void lerEnvelope() throws FalhaDeFuncionamento;
}
