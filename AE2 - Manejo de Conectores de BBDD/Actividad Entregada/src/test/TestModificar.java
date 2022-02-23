package test;

import java.util.Scanner;

import modelo.entidad.Coches;

import modelo.persistencia.DaoCocheMySql;

import modelo.persistencia.interfaces.DaoCoche;

public class TestModificar {

	public static void Modificar() {

		Scanner sc = new Scanner(System.in);
		String marca;
		String modelo;
		String matricula;
		String color;
		int id;
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
		System.out.println(" INTRODUCE EL ID DEL VEHICULO ");
		System.out.println("");
		coche.setId(id = sc.nextInt());

		DaoCoche dp = new DaoCocheMySql();
		boolean modificar = dp.modificar(coche);

		if (modificar) {
			System.out.println("El coche se ha modificado");
		} else {
			System.out.println("El coche NO se ha modificado");
		}

	}
}
