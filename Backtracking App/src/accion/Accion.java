package accion;

import estado.Estado;

@SuppressWarnings("unused")
public interface Accion {
     /**
     *  Encargada de realizar una determinada acción sobre la estructura en el momento en que es llamada.
     **/

     void realizarAccion(Estado e);

     void deshacerAccion(Estado e);

}
