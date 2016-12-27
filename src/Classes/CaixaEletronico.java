package Classes;

public class CaixaEletronico {

	private MockServicoRemoto mock;
	private ContaCorrente conta;

	public String logar(String usuario, String senha, String numeroConta) {
		conta = mock.recuperarConta(numeroConta);

		if (conta.logar(usuario, senha)) {
			return "Usuário Autenticado";

		} else
			return "Não foi possível autenticar o usuário";

	}

	public String sacar(double valor) {

		if (valor <= conta.saldo()){
			conta.sacar(valor);
			this.persistir(conta);
			return "Retire seu dinheiro";
		}
		else
			return "Saldo insuficiente";

	}

	public String depositar(double valor) {
		if (valor >= 0){
			conta.depositar(valor);
			this.persistir(conta);
			return "Depósito recebido com sucesso";
		}
		else
			return "Valor inválido!";

	}

	public String saldo() {
		return "O saldo é R$" + Double.toString(conta.saldo());

	}

	public void adicionarObservador(ServicoRemoto mock) {
		this.mock = (MockServicoRemoto) mock;
	}
	
	public void persistir(ContaCorrente conta){
		this.mock.persistirConta(conta);
	}
	

}
