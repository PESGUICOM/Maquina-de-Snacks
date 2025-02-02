import java.util.ArrayList;
import java.util.List;

public class Snacks {
    private static final List<Snack> snacks;

    //Bloque static inicializador
    static {
        snacks =new ArrayList<>();
        snacks.add(new Snack("Papas", 70));
        snacks.add(new Snack("Gaseosa", 3000));
        snacks.add(new Snack("Tostado", 6500));
        snacks.add(new Snack("Pizza", 10000));
    }

    public static void agregarSnack(Snack snack){
        snacks.add(snack);
    }

    public static void mostrarSnack(){
        var inventarioSnacks = "";
        for (var snack : snacks){
            inventarioSnacks += snack.toString() + "\n";
        }
        System.out.println("--- Snacks en el inventario ---");
        System.out.println(inventarioSnacks);
    }

    public static List<Snack> getSnacks(){
        return snacks;
    }
}
