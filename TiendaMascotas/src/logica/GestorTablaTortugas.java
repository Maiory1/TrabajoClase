package logica;

import java.util.List;

import pojo.Tortuga;
import utils.DBAccessSelects;

public class GestorTablaTortugas {
	
	public void menuVisualTortugas() {
		
		List<Tortuga> tortugas = verTortugas();
		
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
