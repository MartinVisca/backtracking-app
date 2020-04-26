package poda;

import estado.Estado;

public interface Poda {
    /**
     *  Clase encargada de la poda de estados no expandibles.
     **/

    public boolean podar(Estado estado);

    public void visitar(Estado estado);

}
