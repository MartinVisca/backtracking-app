package accion;

import estado.EstadoSumaSubconjuntos;

/**
 * Acción que implementa la interfaz del mismo nombre para el ejemplo de la suma de subconjuntos.
 */
@SuppressWarnings("all")
public class AgregarEntero implements Accion<EstadoSumaSubconjuntos> {

    private int elemento;

    public AgregarEntero(int elemento) {
        this.elemento = elemento;
    }

    @Override
    public void realizarAccion(EstadoSumaSubconjuntos estadoSumaSubconjuntos) {
        estadoSumaSubconjuntos.getEstructura().agregarElemento(elemento);
    }

    @Override
    public void deshacerAccion(EstadoSumaSubconjuntos estadoSumaSubconjuntos) {
        estadoSumaSubconjuntos.getEstructura().borrarElemento(elemento);
    }

    @Override
    public boolean isAccionAplicada(EstadoSumaSubconjuntos estadoSumaSubconjuntos) {
        return estadoSumaSubconjuntos.getEstructura().tieneElemento(elemento);
    }

}
