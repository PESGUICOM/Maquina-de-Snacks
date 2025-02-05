package maquina_snack_archivo.servicio;

import maquina_snack_archivo.dominio.Snack;
import java.util.List;

public interface IServicioSnacks {
    void agregarSnack(Snack snack);
    void mostrarSnacks();
    List<Snack> getSnacks();
}
