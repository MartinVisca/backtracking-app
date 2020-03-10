package condicion;

import estado.Estado;

public interface Condicion {
    /*Interfaz que se usará en las heurísticas encargadas de la poda de estados de la ejecución del backtracking.*/

    public boolean cumpleCondicion(Estado e);
}
