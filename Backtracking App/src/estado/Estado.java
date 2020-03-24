package estado;

import condicion.Condicion;
import estructura.Estructura;

import java.util.Vector;

public abstract class Estado {
     /**
     *   Esta clase representa la configuración de la estructura sobre la que se está trabajando en un momento dado de la
     *   ejecución.
     **/

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
