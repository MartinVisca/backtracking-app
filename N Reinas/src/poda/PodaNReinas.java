package poda;

import estado.EstadoNReinas;

/**
 * Implementación de Poda, adaptada al ejemplo de las N Reinas.
 */
@SuppressWarnings("all")
public class PodaNReinas implements Poda<EstadoNReinas> {

    @Override
    public boolean podar(EstadoNReinas estado) {
        int filas = estado.getEstructura().getFilas();
        int columnas = estado.getEstructura().getColumnas();

        if (estado.getEstructura().getCantidadElementos() > filas)
            return true;

        //Se busca la reina en la estructura. Cuando se encuentra una, se comprueba que no tenga elementos en línea recta y/o diagonal.
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (estado.getEstructura().hayElemento(i, j))
                    if (estado.getEstructura().hayElementoEnRecta(i, j) || estado.getEstructura().hayElementoEnDiagonal(i, j))
                        return true; //Poda si hay elementos que ponen en jaque a la reina.
            }
        }

        return false;
    }

}
