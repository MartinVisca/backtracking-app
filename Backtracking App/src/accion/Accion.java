package accion;

import estado.Estado;

/**
 * Encargada de realizar una determinada acción sobre un estado en el momento en que es llamada.
 */
@SuppressWarnings("all")
public interface Accion<T extends Estado> {

     void realizarAccion(T estado);

     void deshacerAccion(T estado);

     boolean isAccionAplicada(T estado);

}
