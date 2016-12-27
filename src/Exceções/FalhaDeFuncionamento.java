package Exceções;

public class FalhaDeFuncionamento extends Exception {

	private static final long serialVersionUID = 1L;

	public FalhaDeFuncionamento(String msg){
        super(msg);
    }
	
	public FalhaDeFuncionamento(String msg, Throwable cause){
        super(msg, cause);
    }
}
