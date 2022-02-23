package test;

import java.util.Scanner;
import modelo.entidad.Persona;
import modelo.persistencia.DaoPersonaMySql;
import modelo.persistencia.interfaces.DaoPersona;

public class TestAñadirPasajero_Coche {

	public static void añadir_Persona_coche() {
		Scanner sc = new Scanner(System.in);

		int id_coche;
		int id_persona;
		Persona persona = new Persona();
		System.out.println("********* LISTA DE COCHES DISPONIBLES ***********************");
		TestObtener.obtener();
		System.out.println("******************************************************************************");
		System.out.println(" INTRODUCE EL ID DEL COCHE DONDE QUIERES AÑADIR UN PASAJERO ");
		System.out.println("");
		persona.setId_coches(id_coche = sc.nextInt());
		System.out.println("****** LISTA DE PASAJEROS DISPONIBLES ****************************");
		TestListarPasajeros.listar();
		System.out.println("******************************************************************************");
		System.out.println(" INTRODUCE EL ID DEL PASAJERO QUE  QUIERES AÑADIR AL COCHE ");
		System.out.println("");
		persona.setId(id_persona = sc.nextInt());

		DaoPersona dp = new DaoPersonaMySql();
		boolean añadirPersona_coche = dp.añadirPersona_coche(persona);

		if (añadirPersona_coche) {
			System.out.println("El PASAJERO se ha dado de alta en el COCHE");
		} else {
			System.out.println(
					"El PASAJERO NO se ha dado de alta en el COCHE: EL ID DEL COCHE, O ID DEL PASAJERO, SON INCORRECTOS ");
		}

	}

}
