package logica;

import java.util.List;

import pojo.Perro;
import utils.DBAccessSelects;

public class GestorTablaPerros {

	public void menuVisualPerros() {
		
		List<Perro> perros = verPerros();
		
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
}
