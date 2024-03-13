package pojo;

import java.util.Objects;

public class Perro extends Mamifero {

	private String nombre;
	private String raza;
	private boolean vacunado;
	
	/**
	 * 
	 * @param id
	 * @param nombre
	 * @param raza
	 * @param vacunado
	 */
	public Perro(boolean vacunado) {
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
	public boolean getVacunado() {
		return vacunado;
	}
	
	/**
	 * 
	 * @param vacunado
	 */
	public void setVacunado(boolean vacunado) {
		this.vacunado = vacunado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(nombre, raza, vacunado);
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
		return Objects.equals(nombre, other.nombre) && Objects.equals(raza, other.raza) && vacunado == other.vacunado;
	}

	@Override
	public String toString() {
		return "Perro [nombre=" + nombre + ", raza=" + raza + ", vacunado=" + vacunado + "]";
	}
	
}
