package maquina_snack_archivo.presentacion;

import maquina_snack_archivo.dominio.Snack;
import maquina_snack_archivo.servicio.IServicioSnacks;
import maquina_snack_archivo.servicio.ServicioSnacksArchivos;
import maquina_snack_archivo.servicio.ServicioSnacksLista;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaquinaSnacks {
    public static void main(String[] args) {
        maquinaSnacks();
    }

    public static void maquinaSnacks(){
        var salir = false;
        var consola = new Scanner(System.in);
        //Creamos el objeto para obtener el servicio de snacks (lista)
        //IServicioSnacks servicioSnacks = new ServicioSnacksLista();
        IServicioSnacks servicioSnacks = new ServicioSnacksArchivos();
        //Creamos la lista de productos de tipo snack
        List<Snack> productos = new ArrayList<>();
        System.out.println("*** M\u00E1quina de Snacks ***");
        servicioSnacks.mostrarSnacks(); //Mostrar inventario de snacks disponibles
        while (!salir){
            try{
                var opcion = mostrarMenu(consola);
                salir = ejecutarOpciones(opcion, consola, productos, servicioSnacks);
            }catch (Exception e){
                System.out.println("Ocurri\u00F3 un error: " + e.getMessage());
            }
            finally {
                System.out.println(); //Imprime un salto de línea con cada iteración
            }
        }
    }

    private static int mostrarMenu(Scanner consola){
        System.out.print("""
                Men\u00FA:
                1. Comprar snack
                2. Mostrar ticket
                3. Agregar nuevo snack
                4. Inventario Snacks
                5. Salir
                Elige una opci\u00F3n:\s""");
        //Leemos y retornamos la opción seleccionada
        return Integer.parseInt(consola.nextLine());
    }

    private static boolean ejecutarOpciones(int opcion, Scanner consola, List<Snack> productos, IServicioSnacks servicioSnacks){
        var salir = false;
        switch (opcion){
            case 1 -> comprarSnack(consola, productos, servicioSnacks);
            case 2 -> mostrarTicket(productos);
            case 3 -> agregarSnack(consola, servicioSnacks);
            case 4 -> listarInventarioSnacks(consola, servicioSnacks);
            case 5 -> {
                System.out.println("Regresa pronto!");
                System.out.println("Hasta luego!");
                salir = true;
            }
            default -> System.out.println("Opci\u00F3n inv\u00E1lida: " + opcion);
        }
        return salir;
    }

    private static void listarInventarioSnacks(Scanner consola, IServicioSnacks servicioSnacks){
        servicioSnacks.mostrarSnacks();
    }

    private static void comprarSnack(Scanner consola, List<Snack> productos, IServicioSnacks servicioSnacks){
        System.out.print("Qu\u00E9 snack quieres comprar (id)?: ");
        var idSnack = Integer.parseInt(consola.nextLine());
        //Validar que el snack exista en la lista de snacks
        var snackEncontrado = false;
        for (var snack : servicioSnacks.getSnacks()){
            if (idSnack == snack.getIdSnack()){
                //Agregamos el snack a la lista de productos
                productos.add(snack);
                System.out.println("Ok, Snack agregado: " + snack);
                snackEncontrado = true;
                break; //terminamos el ciclo for con break
            }
        }
        if (!snackEncontrado){
            System.out.println("Id de snack NO encontrado: " + idSnack);
        }
    }

    private static void mostrarTicket(List<Snack> productos){
        var ticket = "*** Ticket de Venta ***";
        var total = 0.0;
        for (var producto : productos){
            ticket += "\n\t- " + producto.getNombre() + " - $" + producto.getPrecio();
            total += producto.getPrecio(); //sumando el precio de todos los productos
        }
        ticket += "\n\tTotal -> $" + total;
        System.out.println(ticket);
    }

    private static void agregarSnack(Scanner consola, IServicioSnacks servicioSnacks){
        System.out.print("Nombre del snack: ");
        var nombre = consola.nextLine();
        System.out.print("Precio del snack: ");
        var precio = Double.parseDouble(consola.nextLine());
        servicioSnacks.agregarSnack(new Snack(nombre, precio));
        System.out.println("Tu snack se ha agregado correctamente");
        servicioSnacks.mostrarSnacks();
    }
}
