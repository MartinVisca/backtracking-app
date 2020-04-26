package accion;

import estructura.Estructura;

public interface Accion {
     /**
     *  Encargada de realizar una determinada acción sobre la estructura en el momento en que es llamada.
     **/

     void realizarAccion(Estructura e);

     void deshacerAccion(Estructura e);

}
