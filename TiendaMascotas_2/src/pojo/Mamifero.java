package pojo;

import java.util.Objects;

public abstract class Mamifero extends Animal {
	
	private String nombre = null;
	private String raza = null;
	
	
	/**
	 * 
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getRaza() {
		return raza;
	}
	
	/**
	 * 
	 * @param raza
	 */
	public void setRaza(String raza) {
		this.raza = raza;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(nombre, raza);
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
		Mamifero other = (Mamifero) obj;
		return Objects.equals(nombre, other.nombre) && Objects.equals(raza, other.raza);
	}

	@Override
	public String toString() {
		return "Mamifero [nombre=" + nombre + ", raza=" + raza + "]";
	}
	
	
}
