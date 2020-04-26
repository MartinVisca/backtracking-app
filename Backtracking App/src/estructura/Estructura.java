package estructura;

@SuppressWarnings("unused")
public abstract class Estructura {
     /**
     *  Representante del contenedor sobre el que se realizará el backtracking.
     **/

    public abstract int getCantidadElementos();

    public abstract Estructura getEstructura();

    public abstract void setEstructura(Object nuevaEstructura);

    public abstract void agregarElemento(Object elemento, int ... posicion);

    public abstract void borrarElemento(int ... posicion);

    protected abstract void inicializar();

    public abstract boolean hayElemento(int ... posicion);

    public abstract Object getElemento(int ... posicion);

}
