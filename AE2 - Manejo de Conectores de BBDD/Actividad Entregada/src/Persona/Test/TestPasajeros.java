package Persona.Test;

import java.util.Scanner;

import test.TestAltaPasajero;
import test.TestAñadirPasajero_Coche;
import test.TestBajaPasajero;
import test.TestConsultarPasajero;
import test.TestEliminarPasajero_Coche;
import test.TestListarPasajeros;
import test.TestListarPasajeros_Coche;

public class TestPasajeros {
	public static void GestionPasajeros() {
		boolean salir_gestion = false;

		while (!salir_gestion) {
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("******** INTRODUCE 1  AÑADIR PASAJERO ***************");
			System.out.println();
			System.out.println("******** INTRODUCE 2  BORRAR PASAJERO POR ID ***************");
			System.out.println();
			System.out.println("******** INTRODUCE 3  CONSULTAR PASAJERO POR ID ***************");
			System.out.println();
			System.out.println("******** INTRODUCE 4  LISTAR TODOS LOS PASAJEROS ***************");
			System.out.println();
			System.out.println("******** INTRODUCE 5  AÑADIR PASAJERO A COCHE ***************");
			System.out.println();
			System.out.println("******** INTRODUCE 6  ELIMINAR PASAJERO DE COCHE ***************");
			System.out.println();
			System.out.println("******** INTRODUCE 7 LISTAR TODOS LOS PASAJEROS DE UN COCHE ***************");
			System.out.println();
			System.out.println("******** INTRODUCE 9  VOLVER AL MENU PRINCIPAL ***********");
			System.out.println();
			Scanner sc = new Scanner(System.in);

			int nuevo = sc.nextInt();
			switch (nuevo) {

			case 1:
				System.out.println();
				System.err.println("Has seleccionado la opcion 1 -> AÑADIR PASAJERO ");
				System.out.println();

				TestAltaPasajero.AñadirPersona();

				break;
			case 2:
				System.out.println();
				System.err.println("Has seleccionado la opcion 2 -> BORRAR PASAJERO POR ID ");
				System.out.println();

				TestBajaPasajero.Baja();

				break;
			case 3:
				System.out.println();
				System.err.println("Has seleccionado la opcion 3 -> CONSULTAR PASAJERO POR ID ");
				System.out.println();
				TestConsultarPasajero.consultar();
				break;

			case 4:
				System.out.println();
				System.err.println("Has seleccionado la opcion 4 -> LISTAR TODOS LOS PASAJEROS ");
				System.out.println();
				TestListarPasajeros.listar();
				break;

			case 5:
				System.out.println();
				System.err.println("Has seleccionado la opcion 5 -> AÑADIR PASAJERO A COCHE ");
				System.out.println();
				TestAñadirPasajero_Coche.añadir_Persona_coche();
				break;

			case 6:
				System.out.println();
				System.err.println("Has seleccionado la opcion 6 -> ELIMINAR PASAJERO DE COCHE ");
				System.out.println();
				TestEliminarPasajero_Coche.eliminar_Persona_coche();
				break;

			case 7:
				System.out.println();
				System.err.println("Has seleccionado la opcion 7 -> LISTAR TODOS LOS PASAJEROS DE UN COCHE ");
				System.out.println();
				TestListarPasajeros_Coche.lista_Pasajeros_coche();
				break;

			case 9:
				System.out.println();
				System.err.println("Has seleccionado la opcion 9 -> SALIENDO  DE LA OPCION GESTION DE PASAJEROS ");
				System.out.println("");

				salir_gestion = true;

				break;

			default:
				System.out.println();
				System.err.println("**********************Solo números entre 1 y 9 **********************************");
				System.out.println();
			}

		}

	}

}
