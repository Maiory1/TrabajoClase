package codigo;

import java.util.Scanner;

/**
 * Clase de menus.
 */
public class Menu {

	private Scanner teclado = null;

	public static final int NUMERO_OPCIONES_MENU = 2;

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

	private void ejecutarOpcionMenuInicial(int opcion) {
		System.out.println(" ");
		switch (opcion) {
		case 0:
			System.out.print("Adios!!!");
			break;
		case 1:
			logica.GestorTablaGatos verGatos = new logica.GestorTablaGatos();
			verGatos.menuVisual();
			break;
		case 2:
			System.out.println(" Opcion 2 ");
			break;
		default:
			System.out.println("Esta opcion no deberia salir...");
		}
	}

}

