package pojo;

public class Cocodrilo extends Reptil {

	private int numeroDientes;
	
	public Cocodrilo(int numeroDientes) {
		super();
		this.numeroDientes = numeroDientes;
	}
	
	public Cocodrilo() {
		super();
	}
	
	/**
	 * 
	 * @return
	 */
	public int getNumeroDientes() {
		return numeroDientes;
	}
	
	/**
	 * 
	 * @param numeroDientes
	 */
	public void setNumeroDientes(int numeroDientes) {
		this.numeroDientes = numeroDientes;
	}
	
	
	
}
