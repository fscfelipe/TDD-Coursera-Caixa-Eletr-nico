package Classes;

public class ContaCorrente {

	private String usuario;
	private String senha;
	private String numeroConta;
	private double valor = 0.0;

	public ContaCorrente(String usuario, String senha, String numeroConta) {
		setUsuario(usuario);
		setSenha(senha);
		setNumeroConta(numeroConta);
	}

	public boolean logar(String usuario, String senha) {

		if ((this.usuario == usuario) && (this.senha == senha))
			return true;
		else
			return false;
	}

	public double saldo() {
		return valor;
	}

	public String depositar(double valorDeposito) {
		if (valorDeposito >= 0)
			valor = valor + valorDeposito;
		else
			return "Valor inválido!";
		
		return numeroConta;
	}

	public double sacar(double valorSacado) {
		if (valorSacado <= valor) {
			valor = valor - valorSacado;
			return valorSacado;
		}

		return 0.0;

	}

	private void setUsuario(String usuario) {
		this.usuario = usuario;

	}

	private void setSenha(String senha) {
		this.senha = senha;

	}

	private void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

}
