package logica;

import java.util.List;

import pojo.Gato;
import pojo.Perro;
import pojo.Tortuga;
import utils.DBAccessSelects;

/**
 * Clase de acceso a la tabla GestorTablaGAtos
 */
public class GestorTablaGatos {

	public void menuVisual() {
		
		List<Gato> gatos = verGatos();
		
		List<Perro> perros = verPerros();
		
		List<Tortuga> tortugas = verTortugas();
	}
	
	private List<Gato> verGatos() {
		List<Gato> gatos = new DBAccessSelects().obtenerGatos();
		
		if (!gatos.isEmpty()) {
			for (Gato gato : gatos ) {
				System.out.print(gato.toString());
			}
		}else {
			//nothing
		}
		
		return gatos;
	}
	
	private List<Perro> verPerros() {
		List<Perro> perros = new DBAccessSelects().obtenerPerros();
		
		if (!perros.isEmpty()) {
			for (Perro perro : perros ) {
				System.out.print(perro.toString());
			}
		}else {
			//nothing
		}
		
		return perros;
	}
	
	private List<Tortuga> verTortugas() {
		List<Tortuga> tortugas = new DBAccessSelects().obtenerTortugas();
		
		if (!tortugas.isEmpty()) {
			for (Tortuga tortuga : tortugas ) {
				System.out.print(tortuga.toString());
			}
		}else {
			//nothing
		}
		
		return tortugas;
	}
}
