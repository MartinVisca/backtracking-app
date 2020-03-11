package ejecutorBack;

import condicion.Condicion;
import estado.Estado;

public abstract class Ejecutor {
    /**Clase encargada de llevar a cabo la ejecucion del backtracking.**/

    private Condicion hoja;
    private Condicion poda;
    private Estado solucion;

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

    public abstract void ejecutarBacktracking(Estado inicial, Estado solucion);

    public abstract Estado calcularSolucion();
}
