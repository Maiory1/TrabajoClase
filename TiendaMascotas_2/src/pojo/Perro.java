package pojo;

import java.util.Objects;

public class Perro extends Mamifero {

	private String vacunado;
	
	/**
	 * 
	 * @param vacunado
	 */
	public Perro(String vacunado) {
		super();
		this.vacunado = vacunado;
	}
	
	public Perro() {
		super();
	}
	
	/**
	 * 
	 * @return
	 */
	public String getVacunado() {
		return vacunado;
	}
	
	/**
	 * 
	 * @param string
	 */
	public void setVacunado(String string) {
		this.vacunado = string;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(vacunado);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Perro other = (Perro) obj;
		return Objects.equals(vacunado, other.vacunado);
	}

	@Override
	public String toString() {
		return "Perro [vacunado=" + vacunado + "]";
	}

	
	
}
