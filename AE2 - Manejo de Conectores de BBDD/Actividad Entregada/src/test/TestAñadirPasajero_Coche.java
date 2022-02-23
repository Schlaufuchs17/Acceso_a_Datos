package test;

import java.util.Scanner;
import modelo.entidad.Persona;
import modelo.persistencia.DaoPersonaMySql;
import modelo.persistencia.interfaces.DaoPersona;

public class TestA�adirPasajero_Coche {

	public static void a�adir_Persona_coche() {
		Scanner sc = new Scanner(System.in);

		int id_coche;
		int id_persona;
		Persona persona = new Persona();
		System.out.println("********* LISTA DE COCHES DISPONIBLES ***********************");
		TestObtener.obtener();
		System.out.println("******************************************************************************");
		System.out.println(" INTRODUCE EL ID DEL COCHE DONDE QUIERES A�ADIR UN PASAJERO ");
		System.out.println("");
		persona.setId_coches(id_coche = sc.nextInt());
		System.out.println("****** LISTA DE PASAJEROS DISPONIBLES ****************************");
		TestListarPasajeros.listar();
		System.out.println("******************************************************************************");
		System.out.println(" INTRODUCE EL ID DEL PASAJERO QUE  QUIERES A�ADIR AL COCHE ");
		System.out.println("");
		persona.setId(id_persona = sc.nextInt());

		DaoPersona dp = new DaoPersonaMySql();
		boolean a�adirPersona_coche = dp.a�adirPersona_coche(persona);

		if (a�adirPersona_coche) {
			System.out.println("El PASAJERO se ha dado de alta en el COCHE");
		} else {
			System.out.println(
					"El PASAJERO NO se ha dado de alta en el COCHE: EL ID DEL COCHE, O ID DEL PASAJERO, SON INCORRECTOS ");
		}

	}

}
