package estado;

import accion.Accion;
import estructura.Tablero;

import java.util.HashMap;
import java.util.List;

/**
 * Clase que implementa el Estado correspondiente al ejemplo de las N Reinas.
 */
@SuppressWarnings("all")
public class EstadoNReinas extends Estado<Tablero> {

    public EstadoNReinas() {

    }

    public EstadoNReinas(Tablero tablero, List<Accion> acciones) {
        this.estructura = tablero;
        this.acciones = acciones;
        this.estadosHermanos = new HashMap<>();
        this.estadoPadre = null;
    }

    @Override
    public boolean esSolucion() {
        return this.getEstructura().getCantidadElementos() == this.getEstructura().getFilas();
    }

    @Override
    public String toString() {
        StringBuilder solucion = new StringBuilder();

        solucion.append("<html><body>");

        if (this.esSolucion())
            solucion.append ("------ESTADO SOLUCION------<br>");

        for (int i = 0; i < (this.getEstructura()).getFilas(); i++) {
            for (int j = 0; j < (this.getEstructura()).getColumnas(); j++)
                solucion.append(this.getEstructura().getElemento(i, j)).append("  ");
            solucion.append(System.getProperty("line.separator") + "<br>");
        }

        solucion.append("</body></html>");
        return solucion.toString();
    }

    @Override
    public Estado getEstadoPorCopia() {
        Tablero tablero = this.getEstructura().getEstructuraPorCopia();
        EstadoNReinas estadoNReinas = new EstadoNReinas(tablero, this.getAcciones());
        return estadoNReinas;
    }

}
