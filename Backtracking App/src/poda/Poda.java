package poda;

import estado.Estado;

/**
 * Clase encargada de la poda de estados no expandibles.
 */
@SuppressWarnings("all")
public interface Poda<T extends Estado> {

    boolean podar(T estado);

    void visitar(T estado);

}
