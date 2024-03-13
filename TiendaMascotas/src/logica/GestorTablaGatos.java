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

	public void menuVisualGatos() {
		
		List<Gato> gatos = verGatos();
		
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
	
}
