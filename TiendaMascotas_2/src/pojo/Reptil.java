package pojo;

import java.util.Objects;

public abstract class Reptil extends Animal{
	
	private String especie = null;
	private String tipoAgua = null;
	
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
		Reptil other = (Reptil) obj;
		return Objects.equals(especie, other.especie) && Objects.equals(tipoAgua, other.tipoAgua);
	}

	@Override
	public String toString() {
		return "Reptil [especie=" + especie + ", tipoAgua=" + tipoAgua + "]";
	}
	
	
}
