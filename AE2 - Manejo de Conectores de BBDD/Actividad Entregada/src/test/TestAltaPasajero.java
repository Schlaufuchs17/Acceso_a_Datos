package test;

import java.util.Scanner;

import modelo.entidad.Persona;

import modelo.persistencia.DaoPersonaMySql;

import modelo.persistencia.interfaces.DaoPersona;

public class TestAltaPasajero {
	public static void AñadirPersona() {
		Scanner sc = new Scanner(System.in);
		String nombre;
		int peso;
		int edad;

		Persona persona = new Persona();
		System.out.println(" INTRODUCE EL NOMBRE ");
		System.out.println("");
		persona.setNombre(nombre = sc.next());
		System.out.println(" INTRODUCE EL PESO  ");
		System.out.println("");
		persona.setPeso(peso = sc.nextInt());
		System.out.println(" INTRODUCE LA EDAD ");
		System.out.println("");
		persona.setEdad(edad = sc.nextInt());

		System.out.println("");

		DaoPersona dp = new DaoPersonaMySql();
		boolean alta = dp.alta(persona);

		if (alta) {
			System.out.println("EL SER HUMANO se ha dado de alta");
		} else {
			System.out.println("El ser HUMANO*** NO *** se ha dado de alta");
		}

	}

}
