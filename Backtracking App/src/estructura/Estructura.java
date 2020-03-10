package estructura;

public abstract class Estructura {
    /**Clase abstracta que representa la estructura sobre la que se hará el seguimiento del backtracking.
    Tiene un sólo atributo compartido por sus hijas (estructura) y métodos abstractos que tendrán que ser implementados
    por sus clases hijas.**/

    protected Object estructura;

    public Object getEstructura() {
        return estructura;
    }

    public void setEstructura(Object estructura) {
        this.estructura = estructura;
    }

    public abstract void agregarElemento(Object elemento, int ... posicion);

    public abstract void borrarElemento(int ... posicion);

    public abstract void inicializar();

    public abstract int getCantidadElementos();

    public abstract void imprimirEstructura();

    public abstract boolean hayElemento(int ... posicion);

    public abstract Object getElemento(int ... posicion);
}
