package maquina_snack_archivo.servicio;

import maquina_snack_archivo.dominio.Snack;
import java.util.ArrayList;
import java.util.List;

public class ServicioSnacksLista implements IServicioSnacks{
    private static final List<Snack> snacks;

    //Bloque static inicializador
    static {
        snacks =new ArrayList<>();
        snacks.add(new Snack("Papas", 70));
        snacks.add(new Snack("Gaseosa", 3000));
        snacks.add(new Snack("Tostado", 6500));
        snacks.add(new Snack("Pizza", 10000));
    }

    public void agregarSnack(Snack snack){
        snacks.add(snack);
    }

    public void mostrarSnacks(){
        var inventarioSnacks = "";
        for (var snack : snacks){
            inventarioSnacks += snack.toString() + "\n";
        }
        System.out.println("--- maquina_snack_archivo.servicio.Snacks en el inventario ---");
        System.out.println(inventarioSnacks);
    }

    public List<Snack> getSnacks(){
        return snacks;
    }
}
