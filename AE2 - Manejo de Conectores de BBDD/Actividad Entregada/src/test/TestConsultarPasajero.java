package test;

import java.util.Scanner;

import modelo.entidad.Persona;
import modelo.persistencia.DaoPersonaMySql;
import modelo.persistencia.interfaces.DaoPersona;

public class TestConsultarPasajero {
	public static void consultar() {

		DaoPersona dp = new DaoPersonaMySql();
		Scanner sc = new Scanner(System.in);
		int id;

		System.out.println(" POR FAVOR INTRODUCE EL ID DE LA PERSONA PARA BUSCARLA ");

		id = sc.nextInt();

		Persona persona = dp.consultar(id);
		System.out.println(" esta es la persona que estabas buscando :  " + persona);

	}

}
