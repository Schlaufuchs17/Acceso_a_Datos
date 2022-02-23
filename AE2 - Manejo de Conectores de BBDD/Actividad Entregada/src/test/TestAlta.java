package test;

import modelo.entidad.Coches;
import modelo.persistencia.DaoCocheMySql;

import modelo.persistencia.interfaces.DaoCoche;

import java.util.Scanner;

public class TestAlta {

	public static void Añadir() {
		Scanner sc = new Scanner(System.in);
		String marca;
		String modelo;
		String matricula;
		String color;

		Coches coche = new Coches();
		System.out.println(" INTRODUCE LA MARCA DEL VEHICULO ");
		System.out.println("");
		coche.setMarca(marca = sc.next());
		System.out.println(" INTRODUCE LA MODELO DEL VEHICULO ");
		System.out.println("");
		coche.setModelo(modelo = sc.next());
		System.out.println(" INTRODUCE LA MATRICULA DEL VEHICULO ");
		System.out.println("");
		coche.setMatricula(matricula = sc.next());
		System.out.println(" INTRODUCE EL COLOR DEL VEHICULO ");
		System.out.println("");
		coche.setColor(color = sc.next());

		DaoCoche dp = new DaoCocheMySql();
		boolean alta = dp.alta(coche);

		if (alta) {
			System.out.println("El coche se ha dado de alta");
		} else {
			System.out.println("El coche NO se ha dado de alta");
		}

	}

}
