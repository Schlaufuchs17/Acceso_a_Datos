package test;

import java.util.Scanner;

import modelo.entidad.Coches;
import modelo.persistencia.DaoCocheMySql;

import modelo.persistencia.interfaces.DaoCoche;

public class TestBaja {

	public static void Baja() {

		Scanner sc = new Scanner(System.in);
		int id;

		System.out.println(" POR FAVOR INTRODUCE EL ID DEL COCHE PARA DARLO DE BAJA ");

		id = sc.nextInt();

		DaoCoche dp = new DaoCocheMySql();

		boolean baja = dp.baja(id);
		if (baja) {
			System.out.println("El coche  se ha dado de baja");
		} else {
			System.out.println("El coche NO se ha dado de baja");
		}

	}
}
