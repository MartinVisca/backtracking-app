package estructura;

import impresor.Impresor;

public abstract class Estructura {
     /**
     *  Representante del contenedor sobre el que se realizará el backtracking.
     **/

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
        this.impresor.imprimir(this);
    }

    public abstract Object getEstructura();

    public abstract void agregarElemento(Object elemento, int ... posicion);

    public abstract void borrarElemento(int ... posicion);

    protected abstract void inicializar();

    public abstract boolean hayElemento(int ... posicion);

    public abstract Object getElemento(int ... posicion);
}
