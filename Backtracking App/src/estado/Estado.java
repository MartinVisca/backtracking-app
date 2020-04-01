package estado;

import condicion.Condicion;
import estructura.Estructura;

public abstract class Estado {
     /**
     *   Esta clase representa la configuración de la estructura sobre la que se está trabajando en un momento dado de la
     *   ejecución.
     **/

    private Estructura estructura;

    public Estado(){}

    public Estado(Estructura estructura){
        this.estructura = estructura;
    }

    public Estructura getEstructura() {
        return estructura;
    }

    public void setEstructura(Estructura estructura) {
        this.estructura = estructura;
    }

    public boolean esHoja(Condicion condicion){
        return condicion.cumpleCondicion(this);
    }

    public void imprimirEstado(){
        this.estructura.imprimirEstructura();
    }

    public boolean cumpleCondicion(Condicion condicion){
        return condicion.cumpleCondicion(this);
    }
}
