package codigo;

import java.util.List;
import java.util.Scanner;

import logica.GestorTablaCocodrilos;
import logica.GestorTablaGatos;
import logica.GestorTablaPerros;
import logica.GestorTablaTortugas;
import pojo.Gato;
import pojo.Perro;
import pojo.Tortuga;
import pojo.Cocodrilo;

/**
 * Clase de menus.
 */
public class Menu {

	private GestorTablaGatos gestorGatos = null;
	private GestorTablaPerros gestorPerros = null;
	private GestorTablaTortugas gestorTortugas = null;
	private GestorTablaCocodrilos gestorCocodrilos = null;
	
	private Scanner teclado = null;

	public static final int NUMERO_OPCIONES_MENU = 2;
	
	public static final int NUMERO_OPCIONES_MENU_ANIMALES = 4;

	public Menu() {
		gestorPerros = new GestorTablaPerros();
		gestorGatos = new GestorTablaGatos();
		gestorTortugas = new GestorTablaTortugas();
		gestorCocodrilos = new GestorTablaCocodrilos();
		
		teclado = new Scanner(System.in);
	}

	public void iniciar() {
		int opcion = 0;
		do {
			opcion = opcionMenuInicial();
			if (opcion != 0) {
				ejecutarOpcionMenuInicial(opcion);
			}
		} while (opcion != 0);
	}

	private int opcionMenuInicial() {
		int ret = 0;
		do {
			try {
				escribirMenuInicial();
				System.out.print("Elija una opcion: ");
				ret = teclado.nextInt();
				teclado.nextLine();
			} catch (Exception e) {
				teclado.nextLine();
				ret = -1;
			}
		} while ((ret < 0) || (ret > NUMERO_OPCIONES_MENU));
		return ret;
	}

	private void escribirMenuInicial() {
		System.out.println(" ");
		System.out.println("------------------ MENU ------------------");
		System.out.println("---- 0 - SALIR ");
		System.out.println("---- 1 - Mostrar mascotas ");
		System.out.println("---- 2 - Mostrar mascotas por tipo ");
		System.out.println("---- 3 - Mostrar mascotas por Id ");
		System.out.println("---- 4 - Añadir Mascota ");
		System.out.println("---- 5 - Borrar Mascota ");
		System.out.println("---- 6 - Modificar datos de una mascota ");
		System.out.println("------------------------------------------");
	}
	
	private void ejecutarOpcionMenuInicial(int opcion) {
		System.out.println(" ");
		switch (opcion) {
		case 0:
			System.out.print("Adios!!!");
			break;
		case 1:
			mostrarMascotas();
			break;
		case 2:
			int opcion1 = opcionMenuAnimales();
			ejecutarOpcionMenuAnimales(opcion1);
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		default:
			System.out.println("Esta opcion no deberia salir...");
		}
	}

	/**
	 * This is Option 1 of the initial menu, in which I show all the pets
	 */
	private void mostrarMascotas() {
		System.out.println("--------------------------------");
		List <Perro> perros = gestorPerros.obtenerTodos();
		mostrarPerros(perros);
		System.out.println("--------------------------------");
		List <Gato> gatos = gestorGatos.obtenerTodos();
		mostrarGatos(gatos);
		System.out.println("--------------------------------");
		List <Tortuga> tortugas = gestorTortugas.obtenerTodos();
		mostrarTortugas(tortugas);
		System.out.println("--------------------------------");
		List <Cocodrilo> cocodrilos = gestorCocodrilos.obtenerTodos();
		mostrarCocodrilos(cocodrilos);
	}

	private void mostrarPerros(List <Perro> perros) {
		for (Perro perro : perros) {
			mostrarPerro(perro);
		}
	}
	
	private void mostrarPerro(Perro perro) {
		System.out.println("Id: " + perro.getId());
		System.out.println("Nombre: " + perro.getNombre());
		System.out.println("Raza: " + perro.getRaza());
		System.out.println("Vacunado?: " + perro.getVacunado());
	}
	
	private void mostrarGatos(List <Gato> gatos) {
		for (Gato gato : gatos) {
			mostrarGato(gato);
		}
	}

	private void mostrarGato(Gato gato) {
		System.out.println("Id: " + gato.getId());
		System.out.println("Nombre: " + gato.getNombre());
		System.out.println("Raza: " + gato.getRaza());
		System.out.println("Color: " + gato.getColor());
	}
	
	private void mostrarTortugas(List <Tortuga> tortugas) {
		for (Tortuga tortuga : tortugas) {
			mostrarTortuga(tortuga);
		}
	}

	private void mostrarTortuga(Tortuga tortuga) {
		System.out.println("Id: " + tortuga.getId());
		System.out.println("Especie: " + tortuga.getEspecie());
		System.out.println("Agua Dulce?: " + tortuga.getTipoAgua());
	}
	
	private void mostrarCocodrilos(List<Cocodrilo> cocodrilos) {
		for (Cocodrilo cocodrilo : cocodrilos) {
			mostrarCocodrilos(cocodrilo);
		}
	}
	
	private void mostrarCocodrilos(Cocodrilo cocodrilo) {
		System.out.println("Id: " + cocodrilo.getId());
		System.out.println("Especie: " + cocodrilo.getEspecie());
		System.out.println("Numero Dientes: " + cocodrilo.getNumeroDientes());
		System.out.println("Agua Dulce?: " + cocodrilo.getTipoAgua());
	}

	/**
	 * This is Option 2 of the initial menu, in which I show the pets by type
	 * @return
	 */
	private int opcionMenuAnimales() {
		int ret = 0;
		do {
			try {
				escribirMenuAnimales();
				System.out.print("Elija una opcion: ");
				ret = teclado.nextInt();
				teclado.nextLine();
			} catch (Exception e) {
				teclado.nextLine();
				ret = -1;
			}
		} while ((ret < 0) || (ret > NUMERO_OPCIONES_MENU_ANIMALES));
		return ret;
	}
	
	private void escribirMenuAnimales() {
		System.out.println("¿Qué información quieres ver?");
		System.out.println("0. Volver");
		System.out.println("1. Gatos");
		System.out.println("2. Perros");
		System.out.println("3. Tortugas");
		System.out.println("4. Cocodrilos");
	}
	
	
	
	private void ejecutarOpcionMenuAnimales(int opcion) {
		System.out.println(" ");
		switch (opcion) {
		case 0:
			iniciar();
			break;
		case 1:
			System.out.println("-----------------------------------");
			List <Gato> gatos = gestorGatos.obtenerTodos();
			mostrarGatos(gatos);
			break;
		case 2:
			System.out.println("-----------------------------------");
			List <Perro> perros = gestorPerros.obtenerTodos();
			mostrarPerros(perros);
			break;
		case 3:
			System.out.println("-----------------------------------");
			List <Tortuga> tortugas = gestorTortugas.obtenerTodos();
			mostrarTortugas(tortugas);
			break;
		case 4:
			System.out.println("-----------------------------------");
			List <Cocodrilo> cocodrilos = gestorCocodrilos.obtenerTodos();
			mostrarCocodrilos(cocodrilos);
			break;
		}
	}
	
	/**
	 * This is Option 3 of the initial menu, in which I show the pets by Id
	 */
	
	private void mostrarMascotasTipoPorId() {
		int opcion = 0;
		do {
			opcion = opcionMenuAnimales();
			if (opcion != 0) {
				ejecutarOpcionBuscarMascotasPorId(opcion);
			}
		} while (opcion != 0);
	}
	
	private void ejecutarOpcionBuscarMascotasPorId(int opcion) {
		
		System.out.println();
		
		int id = 0;
		
		switch (opcion) {
		case 1:
			System.out.println("Dame una Id: ");
			id = teclado.nextInt();
			Gato gato = gestorGatos.obtenerPorId(id);
			mostrarGato(gato);
			break;
		case 2:
			System.out.println("Dame una id: ");
			id = teclado.nextInt();
			Perro perro = GestorTablaGatos;
			mostrarPerro(perro);
			break;
		case 3:
			System.out.println("Dame una id: ");
			id = teclado.nextInt();
			Tortuga tortuga = gestorTortugas.obtenerPorId(id);
			mostrarTortuga(tortuga);
			break;
		case 4:
			System.out.println("Dame una id: ");
			id = teclado.nextInt();
			Cocodrilo cocodrilo = gestorCocodrilos.obtenerPorId(id);
			mostrarCocodrilo(cocodrilo);
			break;
		}
	}
	
	/**
	 * This is Option 4 of the initial menu, where we can add pets
	 */
	
	/**
	 * This is Option 5 of the initial menu, where we can eliminate pets
	 */
	
	/**
	 * This is Option 6 of the initial menu, where we can modify pets
	 */
}

