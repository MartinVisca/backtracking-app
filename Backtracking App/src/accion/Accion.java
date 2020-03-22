package accion;

import estructura.Estructura;

public interface Accion {
    /**Interfaz encargada de realizar una determinada accioón sobre la estructura en cuestión. **/

    public void realizarAccion(Estructura e, Object ... parametros);
}
