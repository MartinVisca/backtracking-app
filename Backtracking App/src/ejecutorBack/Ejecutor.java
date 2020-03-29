package ejecutorBack;

import accion.Accion;
import condicion.Condicion;
import estado.Estado;

import java.util.Vector;

public class Ejecutor {
     /**
     * Clase encargada de configurar y ejecutar el algoritmo de backtracking.
     **/

    protected Condicion hoja;
    protected Condicion poda;
    protected Estado solucion;
    protected Accion accion;

    public void setHoja(Condicion hoja) {
        this.hoja = hoja;
    }

    public Condicion getHoja() {
        return hoja;
    }

    public void setPoda(Condicion poda) {
        this.poda = poda;
    }

    public Condicion getPoda() {
        return poda;
    }

    public void setSolucion(Estado solucion) {
        this.solucion = solucion;
    }

    public Estado getSolucion() {
        return solucion;
    }

    public Accion getAccion() {
        return accion;
    }

    public void setAccion(Accion accion) {
        this.accion = accion;
    }

    public void backtrackingEsquemaGeneral(Estado e, Estado solucion){
        //Método que realiza el backtracking en su forma general.

        if (!this.hoja.cumpleCondicion(e))
            this.accion.realizarAccion(e.getEstructura());
        else{
            int nroHijo = 0;
            Vector <Estado> auxiliar = e.getEstadosSiguientes();

            while (!auxiliar.isEmpty()){ //
                Estado siguiente = auxiliar.firstElement();
                auxiliar.removeElementAt(0);

                if (!poda.cumpleCondicion(e))
                    this.backtrackingEsquemaGeneral(siguiente, solucion);
                nroHijo++;
            }
        }
    }

    public void backtrackingPersonalizado(Estado e, Object ... parametros) {
        /*
        *   Método que da la posibilidad de definir un propio backtracking con las herramientas brindadas.
        *   Está vacío porque la intención es que el que use esta librería defina su propio código.
        */
    }
}
