package principal;
import controlador.Controlador;
import vehiculo.Coche;
import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Controlador controlador = new Controlador();
        File file = new File("Coches.dat");

        if(file.exists()) {
            controlador.rellenarAlmacen(file);
            System.out.println("Se ha importado el listado correctamente \n");
        }

        try(Scanner sc = new Scanner(System.in)) {

            boolean continuar = true;
            int num;
            Coche coche;
            do {
                System.out.println("Por favor, introduzca un numero para comenzar:\n" +
                 "1. Añadir coche\n"+ 
                 "2. Borrar coche (ID)\n" + 
                 "3. Consultar coche (ID)\n" + 
                 "4. Listado de coches\n"+ 
                 "5. Exportar a archivo\n" + 
                 "6. Salir");
                num = Integer.parseInt(sc.nextLine());

                switch (num) {
                    case 1:
                        coche = new Coche();
                        System.out.println("Marca:");
                        coche.setMarca(sc.nextLine());
                        System.out.println("Modelo:");
                        coche.setModelo(sc.nextLine());
                        System.out.println("Matrícula:");
                        coche.setMatricula(sc.nextLine());
                        System.out.println("Color");
                        coche.setColor(sc.nextLine());
                        controlador.addCoche(coche);
                        break;
                    case 2:
                        System.out.println("¿Que coche quieres borrar?");
                        controlador.borrar(Integer.parseInt(sc.nextLine()));
                        break;
                    case 3:
                        System.out.println("¿Que coche quieres buscar?");
                        coche = controlador.cocheId(Integer.parseInt(sc.nextLine()));
                        System.out.println(coche.toString());
                        break;
                    case 4:
                        System.out.println("Los siguientes coches se encuentran en almacen:");
                        controlador.lista();
                        break;
                    case 5:
                        controlador.exportarAlmacen();
                        break;
                    case 6:
                        System.out.println("Gracias y adios!");
                        continuar = false;
                        break;
                    default:
                        System.out.println("Pulsa un numero para continuar:");
                }

            } while (continuar);

        } catch (Exception e) {
        }
    }
}