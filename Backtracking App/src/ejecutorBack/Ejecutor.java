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

    public Accion getAccion(int posicion) {
        return this.acciones.get(posicion);
    }

    public void addAccion(Accion accion) {
        this.acciones.add(accion);
    }

    public void backtracking(Estado e, Object ... parametros){
        //Método que realiza el backtracking en su forma general.

        /**
         * El siguiente es un template de como debería estar planteado el algoritmo en su forma más general.
         *

        if (!(el estado es hoja)
            realizar accion;
        else{
            int nroHijo = 0;

            while (hay estados siguientes){ //
                siguiente = generar estado siguiente;

                if (!(se cumple la poda))
                    backtracking(siguiente, solucion);
                nroHijo++;
            }
        }

         **/
    }
}
