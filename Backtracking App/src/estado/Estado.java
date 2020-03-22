package estado;

import condicion.Condicion;
import estructura.Estructura;

import java.util.Vector;

public abstract class Estado {
    /**Estado es la clase que representa cada nodo del árbol con el que se puede ver el recorrido de un algoritmo de backtracking.**/

    private Estructura estructura;

    public Estructura getEstructura() {
        return estructura;
    }

    public void setEstructura(Estructura estructura) {
        this.estructura = estructura;
    }

    public abstract boolean esHoja(Condicion condicion);

    public abstract void imprimirEstado();

    public abstract Vector<Estado> getEstadosSiguientes();

    public abstract boolean cumpleCondicion(Condicion condicion);
}
