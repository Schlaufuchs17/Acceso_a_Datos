package test;

import java.util.Scanner;

import modelo.entidad.Persona;

import modelo.persistencia.DaoPersonaMySql;

import modelo.persistencia.interfaces.DaoPersona;

public class TestListarPasajeros_Coche {

	public static void lista_Pasajeros_coche() {
		int id;
		Scanner sc = new Scanner(System.in);

		DaoPersona dp = new DaoPersonaMySql();

		System.out.println(" POR FAVOR INTRODUCE EL ID DEL COCHE PARA MOSTRAR TODOS SUS PASAJEROS ");

		id = sc.nextInt();

		Persona persona = dp.consultar_persona_coche(id);

	}
}