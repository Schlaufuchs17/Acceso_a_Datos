package test;

import java.util.Scanner;

import modelo.entidad.Persona;
import modelo.persistencia.DaoPersonaMySql;
import modelo.persistencia.interfaces.DaoPersona;

public class TestEliminarPasajero_Coche {

	static int id_coche;

	public static void eliminar_Persona_coche() {
		Scanner sc = new Scanner(System.in);

		int id_persona;

		Persona persona = new Persona();
		System.out.println("****** LISTA DE PASAJEROS DISPONIBLES ****************************");
		TestListarPasajeros.listar();
		System.out.println("******************************************************************************");
		System.out.println(" INTRODUCE EL ID DEL PASAJERO QUE  QUIERES QUITAR DEL COCHE ");
		System.out.println("");
		persona.setId(id_persona = sc.nextInt());

		DaoPersona dp = new DaoPersonaMySql();

		boolean Eliminar_pasajero = dp.Eliminar_pasajero(persona);

		if (Eliminar_pasajero) {
			System.out.println("El PASAJERO se ha dado de BAJA en el COCHE");
		} else {
			System.out.println(
					"El PASAJERO NO se ha dado de BAJA en el COCHE: EL ID DEL COCHE, O ID DEL PASAJERO, SON INCORRECTOS ");
		}

	}

}
