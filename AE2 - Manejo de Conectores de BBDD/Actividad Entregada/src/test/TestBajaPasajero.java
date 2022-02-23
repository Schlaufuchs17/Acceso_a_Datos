package test;

import java.util.Scanner;

import modelo.persistencia.DaoPersonaMySql;

import modelo.persistencia.interfaces.DaoPersona;

public class TestBajaPasajero {
	public static void Baja() {

		Scanner sc = new Scanner(System.in);
		int id;

		System.out.println(" POR FAVOR INTRODUCE EL ID DE LA PERSONA PARA DARLA DE BAJA ");

		id = sc.nextInt();

		DaoPersona dp = new DaoPersonaMySql();

		boolean baja = dp.baja(id);
		if (baja) {
			System.out.println("La persona  se ha dado de baja");
		} else {
			System.out.println("La persona NO se ha dado de baja");
		}

	}
}