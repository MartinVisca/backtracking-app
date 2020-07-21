package acciones;

import accion.Accion;
import estado.EstadoNReinas;

/**
 * Implementación de Acción, adaptada al ejemplo de las N Reinas.
 */
@SuppressWarnings("all")
public class ColocarReina implements Accion<EstadoNReinas> {

    private final int fila;
    private final int columna;

    public final static String REINA = "R";

    public ColocarReina(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    @Override
    public void realizarAccion(EstadoNReinas estado) {
        estado.getEstructura().agregarElemento(REINA, fila, columna);
    }

    @Override
    public void deshacerAccion(EstadoNReinas estado) {
        estado.getEstructura().borrarElemento(fila, columna);
    }

    @Override
    public boolean isAccionAplicada(EstadoNReinas estado) {
        return estado.getEstructura().hayElemento(fila, columna);
    }

}
