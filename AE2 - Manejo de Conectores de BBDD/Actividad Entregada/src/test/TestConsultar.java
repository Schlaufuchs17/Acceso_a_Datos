package test;

import java.util.List;
import java.util.Scanner;

import modelo.entidad.Coches;
import modelo.persistencia.DaoCocheMySql;
import modelo.persistencia.interfaces.DaoCoche;

public class TestConsultar {

	public static void consultar() {

		DaoCoche dp = new DaoCocheMySql();
		Scanner sc = new Scanner(System.in);
		int id;

		System.out.println(" POR FAVOR INTRODUCE EL ID DEL COCHE PARA DARLO DE BAJA ");

		id = sc.nextInt();

		Coches coche = dp.consultar(id);
		System.out.println(" este es el coche que estabas buscando :  " + coche);

	}
}
