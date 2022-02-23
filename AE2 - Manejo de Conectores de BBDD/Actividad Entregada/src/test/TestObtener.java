package test;

import java.util.List;

import modelo.entidad.Coches;
import modelo.persistencia.DaoCocheMySql;

import modelo.persistencia.interfaces.DaoCoche;


public class TestObtener {
	
	public static void obtener() {
	
	DaoCoche dp = new DaoCocheMySql();
	
	
	System.out.println("********* LISTANDO TODOS LOS COCHES  **********");
	
	List<Coches> listaCoches = dp.listar();
	for(Coches p : listaCoches){
		System.out.println(p);
		
	}
	
	}	
	
}

