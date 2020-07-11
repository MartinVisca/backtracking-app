package estado;

import accion.Accion;
import estructura.Estructura;
import poda.Poda;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SuppressWarnings("all")
public abstract class Estado {
    /**
     *  Clase que representa al estado en el que se encuentra el objeto sobre el que se realiza el backtracking en un momento dado
     *  de la ejecución.
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

    public Set<String> backtracking(Poda poda) {
        Set<String> estadosFactibles = new HashSet<>();

        if (this.esSolucion()) {
            estadosFactibles.add(this.toString());
        }
        else {
            for (Accion accion : this.acciones){
                if (!accion.isAccionAplicada(this)) {
                    accion.realizarAccion(this);
                    if (!poda.podar(this))
                        //estadosFactibles.add(this.toString());
                        estadosFactibles.addAll(this.backtracking(poda));
                    accion.deshacerAccion(this);
                }
            }
        }

        return estadosFactibles;
    }

    public abstract boolean esSolucion();

    public abstract String toString();

}
