package estado;

import accion.Accion;
import estructura.Estructura;
import poda.Poda;
import java.util.HashMap;
import java.util.List;

/**
 * Clase que representa al estado en el que se encuentra el objeto sobre el que se realiza el backtracking en un momento dado
 * de la ejecución.
 */
@SuppressWarnings("all")
public abstract class Estado<T extends Estructura> {

    protected T estructura;
    protected List<Accion> acciones;
    protected HashMap<String, Estado> estadosHermanos;
    protected Estado estadoPadre;

    public T getEstructura() {
        return this.estructura;
    }

    public void setEstructura(T estructura) {
        this.estructura = estructura;
    }

    public List<Accion> getAcciones() {
        List<Accion> copia = this.acciones.subList(0, acciones.size());
        return copia;
    }

    public void setAcciones(List<Accion> acciones) {
        this.acciones = acciones;
    }

    public HashMap<String, Estado> getEstadosHermanos() {
        return estadosHermanos;
    }

    public void setEstadosHermanos(HashMap<String, Estado> estadosHermanos) {
        this.estadosHermanos = estadosHermanos;
    }

    public Estado getEstadoPadre() {
        return estadoPadre;
    }

    public void setEstadoPadre(Estado estadoPadre) {
        this.estadoPadre = estadoPadre;
    }

    public void addAccion(Accion accion) {
        this.acciones.add(accion);
    }

    public void borrarAccion(Accion accion) {
        this.acciones.remove(accion);
    }

    public HashMap<String, Estado> backtracking(Poda poda) {
        HashMap<String, Estado> estadosFactibles = new HashMap<>();

        if (this.esSolucion()) {
            estadosFactibles.put(this.toString(), this.getEstadoPorCopia());
        }
        else {
            for (Accion accion : this.acciones){
                if (!accion.isAccionAplicada(this)) {
                    accion.realizarAccion(this);
                    if (!poda.podar(this))
                        estadosFactibles.put(this.toString(), this.getEstadoPorCopia());
                    accion.deshacerAccion(this);
                }
            }
        }

        return estadosFactibles;
    }

    public abstract boolean esSolucion();

    public abstract String toString();

    public abstract Estado getEstadoPorCopia();

}
