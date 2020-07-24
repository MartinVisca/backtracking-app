package estructura;

/**
 * Representante del contenedor sobre el que se realizará el backtracking.
 */
@SuppressWarnings("all")
public abstract class Estructura<T> {

    public abstract void setEstructura(T nuevaEstructura);

    public abstract Estructura getEstructuraPorCopia();

    protected abstract void inicializar();

}
