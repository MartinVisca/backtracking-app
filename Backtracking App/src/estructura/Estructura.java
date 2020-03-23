package estructura;

public abstract class Estructura {
    /**Clase abstracta que representa la estructura sobre la que se hará el seguimiento del backtracking. **/

    public abstract Object getEstructura();

    public abstract void agregarElemento(Object elemento, int ... posicion);

    public abstract void borrarElemento(int ... posicion);

    protected abstract void inicializar();

    public abstract int getCantidadElementos();

    public abstract void imprimirEstructura();

    public abstract boolean hayElemento(int ... posicion);

    public abstract Object getElemento(int ... posicion);
}
