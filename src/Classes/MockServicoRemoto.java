package Classes;

import java.util.ArrayList;

public class MockServicoRemoto implements ServicoRemoto {

	ArrayList<ContaCorrente> listaContas = new ArrayList();
	
	@Override
	public ContaCorrente recuperarConta(String numero) {
		return null;
	}

	@Override
	public void persistirConta() {
		
	}

}
