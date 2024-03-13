package pojo;

public class Tortuga {

	private int idTortuga;
	private String especie;
	private String tipoAgua;
	
	public Tortuga(int idTortuga, String especie, String tipoAgua) {
		super();
		this.idTortuga = idTortuga;
		this.especie = especie;
		this.tipoAgua = tipoAgua;
	}
	
	public Tortuga() {
		super();
	}
	
	public int getIdTortuga() {
		return idTortuga;
	}
	
	public void setIdTortuga(int idTortuga) {
		this.idTortuga = idTortuga;
	}
	
	public String getEspecie() {
		return especie;
	}
	
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	
	public String getTipoAgua() {
		return tipoAgua;
	}
	
	public void setTipoAgua(String tipoAgua) {
		this.tipoAgua = tipoAgua;
	}
	@Override
	public String toString() {
		return "\n" +"--- Tortuga ---" + "\n" + "idTortuga: " + idTortuga + "\n" + "especie: " + especie + "\n" + "tipoAgua: " + tipoAgua + "\n";
	}
}
