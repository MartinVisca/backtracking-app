package accion;

import estructura.Estructura;

public interface Accion {
     /**
     *  Encargada de realizar una determinada acción sobre la estructura en el momento en que es llamada.
     **/

    public void realizarAccion(Estructura e, Object ... parametros);
}
