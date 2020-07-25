package poda;

import estado.EstadoSumaSubconjuntos;

/**
 * Clase que implementa la Poda para la suma de subconjuntos.
 */
@SuppressWarnings("all")
public class PodaSumaSubconjuntos implements Poda<EstadoSumaSubconjuntos> {

    @Override
    public boolean podar(EstadoSumaSubconjuntos estadoSumaSubconjuntos) {
        int target = estadoSumaSubconjuntos.getTarget();
        int sumaSubconjunto = estadoSumaSubconjuntos.getEstructura().getSumaElementos();

        if (target < sumaSubconjunto)
            return true;
        return false;
    }

}
