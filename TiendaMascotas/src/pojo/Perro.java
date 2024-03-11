package pojo;

import java.util.Objects;

public class Perro {

	private int idCollarP;
	private String nomPerro;
	private String razaP;
	private String vacunado;
	
	/**
	 * 
	 * @param idCollarP
	 * @param nomPerro
	 * @param razaP
	 * @param vacunado
	 */
	public Perro(int idCollarP, String nomPerro, String razaP, String vacunado) {
		super();
		this.idCollarP = idCollarP;
		this.nomPerro = nomPerro;
		this.razaP = razaP;
		this.vacunado = vacunado;
	}
	
	public Perro() {
		super();
	}
	
	/**
	 * 
	 * @return
	 */
	public int getIdCollarP(){
		return idCollarP;
	}
	
	public void setIdCollarP(int idCollarP) {
		this.idCollarP = idCollarP;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getNomPerro() {
		return nomPerro;
	}
	
	/**
	 * 
	 * @param nomPerro
	 */
	public void setNomPerro(String nomPerro) {
		this.nomPerro = nomPerro;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getRazaP() {
		return razaP;
	}
	
	/**
	 * 
	 * @param razaP
	 */
	public void setRazaP(String razaP) {
		this.razaP = razaP;
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
	 * @param vacunado
	 */
	public void setVacunado(String vacunado) {
		this.vacunado = vacunado;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idCollarP, nomPerro, razaP, vacunado);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Perro other = (Perro) obj;
		return idCollarP == other.idCollarP;
	}

	@Override
	public String toString() {
		return "Perro [idCollarP=" + idCollarP + ", nomPerro=" + nomPerro + ", razaP=" + razaP + "vacunado=" + vacunado + "]";
	}
	
}
