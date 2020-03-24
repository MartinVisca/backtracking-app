package condicion;

import estado.Estado;

public interface Condicion {
     /**
     *  Como su nombre lo indica, representa los diferentes requisitos que debe cumplir un estado ya sea para determinar si es hoja
     *  o un estado podado.
     **/

    public boolean cumpleCondicion(Estado e);
}
