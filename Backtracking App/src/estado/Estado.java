package estado;

import accion.Accion;
import estructura.Estructura;

import java.util.List;

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

    public void aplicarAcciones() {
        for (Accion accion : this.acciones){
            accion.realizarAccion(estructura);
        }
    }

    public void imprimirEstado() {
        this.estructura.imprimirEstructura();
    }

    public void backtracking() {
        //Falta definición
    }

    public abstract boolean cumpleCondicion();

    public abstract boolean esSolucion();

}
