package Classes;

public class MockHardware implements Hardware {

	String numero;
	
	@Override
	public String pegarNumeroDaContaCartao(ContaCorrente conta) {
		numero = conta.getNumeroConta();
		return null;
	}

	@Override
	public void entregarDinheiro() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void lerEnvelope() {
		// TODO Auto-generated method stub
		
	}
	
	public String getNumero(){
		return numero;
	}

}
