package Exceções;

public class SaldoInsuficiente extends Exception {

	private static final long serialVersionUID = 1L;
	
	public SaldoInsuficiente(String msg){
        super(msg);
    }
	
	public SaldoInsuficiente(String msg, Throwable cause){
        super(msg, cause);
    }
	
}
