package test;

import java.util.List;
import modelo.entidad.Persona;
import modelo.persistencia.DaoPersonaMySql;
import modelo.persistencia.interfaces.DaoPersona;

public class TestListarPasajeros {

	public static void listar() {

		DaoPersona dp = new DaoPersonaMySql();

		// a partir de esta parte para abajo sobra.... esto es para la otra parte que es
		// obtener todos los coches

		System.out.println("********* LISTANDO TODAS LAS PERSONAS **********");

		List<Persona> listaPasajeros = dp.listar();
		for (Persona p : listaPasajeros) {
			System.out.println(p);

		}
System.out.println("*******************************************************************************************************");
	}
}
