package estado;

import estructura.Estructura;

public abstract class Estado {
     /**
     *   Esta clase representa la configuración de la estructura sobre la que se está trabajando en un momento dado de la
     *   ejecución.
     **/

    private Estructura estructura;

    public Estructura getEstructura() {
        return estructura.getEstructura();
    }

    public void setEstructura(Estructura estructura) {
        this.estructura = estructura;
    }

    public void imprimirEstado(){
        this.estructura.imprimirEstructura();
    }

    public abstract boolean cumpleCondicion();

    public abstract boolean esSolucion();
}
