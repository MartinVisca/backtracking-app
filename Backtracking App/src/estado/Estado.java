package estado;

import accion.Accion;
import estructura.Estructura;
import poda.Poda;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public abstract class Estado {
     /**
     *   Esta clase representa la configuración de la estructura sobre la que se está trabajando en un momento dado de la
     *   ejecución.
     **/

    protected Estructura estructura;
    protected List<Accion> acciones;

    public Estructura getEstructura() {
        return estructura.getEstructura();
    }

    public void setEstructura(Estructura estructura) {
        this.estructura = estructura;
    }

    public List<Accion> getAcciones() {
        List<Accion> copia = this.acciones.subList(0, acciones.size());
        return copia;
    }

    public void setAcciones(List<Accion> acciones) {
        this.acciones = acciones;
    }

    public void addAccion(Accion accion) {
        this.acciones.add(accion);
    }

    public void borrarAccion(Accion accion) {
        this.acciones.remove(accion);
    }

    public List<String> backtracking(Poda poda) {
        List<String> estadosFactibles = new ArrayList<>();

        if (this.esSolucion()) {
            estadosFactibles.add(this.solucionToString());
        }
        else {
            for (Accion accion : this.acciones){
                accion.realizarAccion(this);
                if (poda.podar(this))
                    estadosFactibles.add(this.toString());
                accion.deshacerAccion(this);
            }
        }

        return estadosFactibles;
    }

    public abstract boolean cumpleCondicion();

    public abstract boolean esSolucion();

    public abstract String toString();

    public abstract String solucionToString();

}
