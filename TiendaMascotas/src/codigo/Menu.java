package codigo;

import java.util.Scanner;

/**
 * Clase de menus.
 */
public class Menu {

	private Scanner teclado = null;

	public static final int NUMERO_OPCIONES_MENU = 2;
	
	public static final int NUMERO_OPCIONES_MENU_ANIMALES = 3;

	public Menu() {
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
		} while ((ret < 0) && (ret > NUMERO_OPCIONES_MENU));
		return ret;
	}

	private void escribirMenuInicial() {
		System.out.println(" ");
		System.out.println("---- MENU ----");
		System.out.println("---- 0 - SALIR ");
		System.out.println("---- 1 - Opcion 1 ");
		System.out.println("---- 2 - Opcion 2 ");
		System.out.println("--------------");
	}
	
	private void escribirMenuAnimales() {
		System.out.println("¿Qué información quieres ver?");
		System.out.println("0. Volver");
		System.out.println("1. Gatos");
		System.out.println("2. Perros");
		System.out.println("3. Tortugas");
	}
	
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
		} while ((ret < 0) && (ret > NUMERO_OPCIONES_MENU_ANIMALES));
		return ret;
	}
	
	private void ejecutarOpcionMenuAnimales(int opcion) {
		System.out.println(" ");
		switch (opcion) {
		case 0:
			iniciar();
			break;
		case 1:
			logica.GestorTablaGatos verGatos = new logica.GestorTablaGatos();
			verGatos.menuVisualGatos();
			break;
		case 2:
			logica.GestorTablaPerros verPerros = new logica.GestorTablaPerros();
			verPerros.menuVisualPerros();
			break;
		case 3:
			logica.GestorTablaTortugas verTortugas = new logica.GestorTablaTortugas();
			verTortugas.menuVisualTortugas();
			break;
		default:
			System.out.println("Esta opcion no deberia salir...");
		}
	}

	private void ejecutarOpcionMenuInicial(int opcion) {
		System.out.println(" ");
		switch (opcion) {
		case 0:
			System.out.print("Adios!!!");
			break;
		case 1:
			logica.GestorTablaGatos verGatos = new logica.GestorTablaGatos();
			logica.GestorTablaPerros verPerros = new logica.GestorTablaPerros();
			logica.GestorTablaTortugas verTortugas = new logica.GestorTablaTortugas();
			verGatos.menuVisualGatos();
			verPerros.menuVisualPerros();
			verTortugas.menuVisualTortugas();
			break;
		case 2:
			int opcion1 = opcionMenuAnimales();
			ejecutarOpcionMenuAnimales(opcion1);
			break;
		default:
			System.out.println("Esta opcion no deberia salir...");
		}
	}
	
	
	
	

}

