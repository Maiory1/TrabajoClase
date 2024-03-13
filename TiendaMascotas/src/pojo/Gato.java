package pojo;

import java.util.Objects;

public class Gato {

	private int idCollarG;
	private String nomGato;
	private String razaG;
	
	/**
	 * 
	 * @param idCollarG
	 * @param nomGato
	 * @param razaG
	 */
	
	public Gato(int idCollarG, String nomGato, String razaG) {
		super();
		this.idCollarG = idCollarG;
		this.nomGato = nomGato;
		this.razaG = razaG;
	}
	
	public Gato() {
		super();
	}
	
	/**
	 * Devuelve la idCollarG
	 * @return
	 */
	public int getIdCollarG() {
		return idCollarG;
	}
	
	/**
	 * 
	 * @param idCollarG
	 */
	public void setIdCollarG(int idCollarG) {
		this.idCollarG = idCollarG;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getNomGato() {
		return nomGato;
	}
	
	/**
	 * 
	 * @param nomGato
	 */
	public void setNomGato(String nomGato) {
		this.nomGato = nomGato;	
	}
	
	/**
	 * 
	 * @return
	 */
	public String getRazaG() {
		return razaG;
	}
	
	/**
	 * 
	 * @param razaG
	 */
	public void setRazaG(String razaG) {
		this.razaG = razaG;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idCollarG, nomGato, razaG);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gato other = (Gato) obj;
		return idCollarG == other.idCollarG;
	}

	@Override
	public String toString() {
		return "\n" + "--- Gato ---" + "\n" + "idCollarG: " + idCollarG + "\n" + "nomGato: " + nomGato + "\n" + " razaG: " + razaG + ": \n";
	}
}
