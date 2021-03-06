package test;

import java.util.Scanner;
import modelo.entidad.Persona;
import modelo.persistencia.DaoPersonaMySql;
import modelo.persistencia.interfaces.DaoPersona;

public class TestAņadirPasajero_Coche {

	public static void aņadir_Persona_coche() {
		Scanner sc = new Scanner(System.in);

		int id_coche;
		int id_persona;
		Persona persona = new Persona();
		System.out.println("********* LISTA DE COCHES DISPONIBLES ***********************");
		TestObtener.obtener();
		System.out.println("******************************************************************************");
		System.out.println(" INTRODUCE EL ID DEL COCHE DONDE QUIERES AŅADIR UN PASAJERO ");
		System.out.println("");
		persona.setId_coches(id_coche = sc.nextInt());
		System.out.println("****** LISTA DE PASAJEROS DISPONIBLES ****************************");
		TestListarPasajeros.listar();
		System.out.println("******************************************************************************");
		System.out.println(" INTRODUCE EL ID DEL PASAJERO QUE  QUIERES AŅADIR AL COCHE ");
		System.out.println("");
		persona.setId(id_persona = sc.nextInt());

		DaoPersona dp = new DaoPersonaMySql();
		boolean aņadirPersona_coche = dp.aņadirPersona_coche(persona);

		if (aņadirPersona_coche) {
			System.out.println("El PASAJERO se ha dado de alta en el COCHE");
		} else {
			System.out.println(
					"El PASAJERO NO se ha dado de alta en el COCHE: EL ID DEL COCHE, O ID DEL PASAJERO, SON INCORRECTOS ");
		}

	}

}
