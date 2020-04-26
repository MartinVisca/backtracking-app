package poda;

import estado.Estado;

@SuppressWarnings("unused")
public interface Poda {
    /**
     *  Clase encargada de la poda de estados no expandibles.
     **/

    boolean podar(Estado estado);

    void visitar(Estado estado);

}
