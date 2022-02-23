package main;

import java.util.Scanner;

import Persona.Test.TestPasajeros;
import test.TestAlta;
import test.TestBaja;
import test.TestConsultar;
import test.TestModificar;
import test.TestObtener;

public class Main {

	public static void main(String[] args) {
		boolean salir = false;

		while (!salir) {
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("******** INTRODUCE 1  AÑADIR COCHE NUEVO ***************");
			System.out.println();
			System.out.println("******** INTRODUCE 2  BORRAR COCHE POR ID ***************");
			System.out.println();
			System.out.println("******** INTRODUCE 3  CONSULTAR COCHE POR ID ***************");
			System.out.println();
			System.out.println("******** INTRODUCE 4  MODIFICAR COCHE POR ID ***************");
			System.out.println();
			System.out.println("******** INTRODUCE 5  LISTADO DE COCHES ***************");
			System.out.println();
			System.out.println("******** INTRODUCE 6  GESTION DE PASAJEROS ***************");
			System.out.println();
			System.out.println("******** INTRODUCE 7  FINALIZAR EL PROGRAMA ***********");
			System.out.println();
			Scanner sc = new Scanner(System.in);

			int menu = sc.nextInt();
			switch (menu) {
			case 1:
				System.out.println();
				System.err.println("Has seleccionado la opcion 1 -> AÑADIR COCHE NUEVO ");
				System.out.println();
				TestAlta.Añadir();

				break;
			case 2:
				System.out.println();
				System.err.println("Has seleccionado la opcion 2 -> BORRAR COCHE POR ID ");
				System.out.println();
				TestBaja.Baja();

				break;
			case 3:
				System.out.println();
				System.err.println("Has seleccionado la opcion 3 -> CONSULTAR COCHE POR ID ");
				System.out.println();
				TestConsultar.consultar();

				break;

			case 4:
				System.out.println();
				System.err.println("Has seleccionado la opcion 4 -> MODIFICAR COCHE POR ID ");
				System.out.println();
				TestModificar.Modificar();
				break;

			case 5:
				System.out.println();
				System.err.println("Has seleccionado la opcion 5 -> LISTADO DE COCHES ");
				System.out.println();
				TestObtener.obtener();
				break;

			case 6:
				System.out.println();
				System.err.println("Has seleccionado la opcion 6 -> GESTION DE PASAJEROS ");
				System.out.println();
				TestPasajeros.GestionPasajeros();
				break;

			case 7:
				System.out.println();
				System.err.println("Has seleccionado la opcion 7 -> FINALIZAR PROGRAMA ");
				System.out.println("");
				System.out.println(" PROGRAMA FINALIZADO  ");
				salir = true;

				sc.close(); // cerramos scanner

				break;

			default:
				System.out.println();
				System.err.println("**********************Solo números entre 1 y 7 **********************************");
				System.out.println();
			}

		}

	}

}
