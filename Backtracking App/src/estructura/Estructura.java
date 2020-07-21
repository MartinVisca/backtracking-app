package estructura;

/**
 * Representante del contenedor sobre el que se realizará el backtracking.
 */
@SuppressWarnings("all")
public abstract class Estructura<T> {

    public abstract int getCantidadElementos();

    public abstract void setEstructura(T nuevaEstructura);

    public abstract Estructura getEstructuraPorCopia();

    public abstract void agregarElemento(Object elemento, int ... posicion);

    public abstract void borrarElemento(int ... posicion);

    protected abstract void inicializar();

    public abstract boolean hayElemento(int ... posicion);

    public abstract Object getElemento(int ... posicion);

}
