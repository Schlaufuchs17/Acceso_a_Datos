package controlador;
import vehiculo.Coche;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Controlador implements Serializable {
    private static final long serialVersionUID = -1L;
    public ArrayList<Coche> almacen;
    private int acum = 0;

/* Primero creamos el constructor y el arraylist */
    public Controlador() {
        super();
        almacen = new ArrayList<Coche>();
    }

    public String addCoche(Coche coche) {
        if(localizarCoche(coche.getMatricula()) != null) {
            return "El coche ya existe";
        }else {
            Collections.sort(almacen);
            coche.setId(comprobador(acum));
            almacen.add(coche);
            return "El coche se ha añadido";
        }
    }

    public String localizarCoche(String matricula) {
        Coche coche;
        for (int i = 0; i < almacen.size(); i++) {
            coche = almacen.get(i);
            if (coche.getMatricula().equalsIgnoreCase(matricula)) {
                return coche.toString();
            }
        }
        return null;
    }

    public Coche cocheId(int id) {
        for (Coche c : almacen) {
            if (c.getId() == id) {
                return c;
            }
        }
        System.out.println("No se ha encontrado nada");
        return null;
    }

    public Coche borrar(int id) {
        try {
            Coche c = cocheId(id);
            int n = almacen.indexOf(c);
            return almacen.remove(n);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Nada que mostrar");
            return null;
        }
    }

    public void lista(){
        if(!almacen.isEmpty()) {
            Collections.sort(almacen);
            for (Coche c : almacen) {
                System.out.println(c.toString());
            }
        }else {
            System.out.println("Almacén vacío");
        }
    }

    public int comprobador(int id) {
        for(int i=0;i<almacen.size();i++) {
            if(almacen.get(i).getId()==id) {
                ++id;
            }
        }
        return id;
    }

    public String rellenarAlmacen(File file){
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis);) {
            @SuppressWarnings("unchecked")
            ArrayList<Coche> lista = (ArrayList<Coche>)ois.readObject();
            almacen = lista;
            return "Archivo cargado con exito";

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        }
        return null;
    }

/* Creamos el archivo de texto donde se exportaran los listados de los coches */
    public void exportarAlmacen() {

        try(FileWriter fw = new FileWriter(new File("Listado.txt"));
            BufferedWriter bw = new BufferedWriter(fw);) {
            for(int i=0 ; i<almacen.size() ; i++) {
                bw.write(almacen.get(i).toString());
                bw.newLine();
            }
            bw.flush();
            System.out.println("Archivo creado: Listado.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileOutputStream fos = new FileOutputStream(new File("Coches.dat"));
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(almacen);
            System.out.println("El archivo se encuentra en Coches.dat");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}