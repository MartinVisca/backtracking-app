package estructura;

import impresor.Impresor;

public abstract class Estructura {
    /**Clase abstracta que representa la estructura sobre la que se hará el seguimiento del backtracking. **/

    protected int cantidadElementos;
    protected Impresor impresor;

    public int getCantidadElementos(){
        return this.cantidadElementos;
    }

    public Impresor getImpresor() {
        return impresor;
    }

    public void setImpresor(Impresor impresor) {
        this.impresor = impresor;
    }

    public void imprimirEstructura(){
        try {
            this.impresor.imprimir((Estructura) this.clone());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    public abstract Object getEstructura();

    public abstract void agregarElemento(Object elemento, int ... posicion);

    public abstract void borrarElemento(int ... posicion);

    protected abstract void inicializar();

    public abstract boolean hayElemento(int ... posicion);

    public abstract Object getElemento(int ... posicion);
}
