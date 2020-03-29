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
    protected Vector<Condicion> podas;
    protected Estado solucion;
    protected Vector<Accion> acciones;

    public Ejecutor(){
        this.podas = new Vector<>();
        this.acciones = new Vector<>();
    }

    public void setHoja(Condicion hoja) {
        this.hoja = hoja;
    }

    public Condicion getHoja() {
        return hoja;
    }

    public void addPoda(Condicion poda) {
        this.podas.add(poda);
    }

    public Condicion getPoda(int posicion) {
        return this.podas.get(posicion);
    }

    public void setSolucion(Estado solucion) {
        this.solucion = solucion;
    }

    public Estado getSolucion() {
        return solucion;
    }

    public Accion getAccion(int posicion) {
        return this.acciones.get(posicion);
    }

    public void addAccion(Accion accion) {
        this.acciones.add(accion);
    }

    public void backtrackingEsquemaGeneral(Estado e, Estado solucion){
        //Método que realiza el backtracking en su forma general.

        if (!this.hoja.cumpleCondicion(e))
            this.acciones.firstElement().realizarAccion(e.getEstructura());
        else{
            int nroHijo = 0;
            Vector <Estado> auxiliar = e.getEstadosSiguientes();

            while (!auxiliar.isEmpty()){ //
                Estado siguiente = auxiliar.firstElement();
                auxiliar.removeElementAt(0);

                if (!podas.firstElement().cumpleCondicion(e))
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
