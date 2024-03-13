package pojo;

import java.util.Objects;

public class Tortuga extends Animal {

	private String especie;
	private String tipoAgua;
	
	/**
	 * 
	 * @param id
	 * @param especie
	 * @param tipoAgua
	 */
	public Tortuga(String especie, String tipoAgua) {
		super();
		this.especie = especie;
		this.tipoAgua = tipoAgua;
	}
	
	public Tortuga() {
		super();
	}
	
	/**
	 * 
	 * @return
	 */
	public String getEspecie() {
		return especie;
	}
	
	/**
	 * 
	 * @param especie
	 */
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getTipoAgua() {
		return tipoAgua;
	}
	
	/**
	 * 
	 * @param tipoAgua
	 */
	public void setTipoAgua(String tipoAgua) {
		this.tipoAgua = tipoAgua;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(especie, tipoAgua);
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
		Tortuga other = (Tortuga) obj;
		return Objects.equals(especie, other.especie) && Objects.equals(tipoAgua, other.tipoAgua);
	}

	@Override
	public String toString() {
		return "Tortuga [especie=" + especie + ", tipoAgua=" + tipoAgua + "]";
	}
	
	
}
