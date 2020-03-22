package condicion;

import estado.Estado;

public class CondicionCompuesta implements Condicion {
    /** Una de las posibles implementaciones de Condicion. En este caso se pensó a la clase con la intención de tener un recurso
     * para controlar el cumplimiento de dos o mas condiciones al mismo tiempo.
     */

    private Condicion c1;
    private Condicion c2;

    public CondicionCompuesta(Condicion c1, Condicion c2){
        this.c1 = c1;
        this.c2 = c2;
    }

    public CondicionCompuesta(){

    }

    public void setC1(Condicion c1) {
        this.c1 = c1;
    }

    public void setC2(Condicion c2) {
        this.c2 = c2;
    }

    public Condicion getC1() {
        return c1;
    }

    public Condicion getC2() {
        return c2;
    }

    @Override
    public boolean cumpleCondicion(Estado e) {
        return c1.cumpleCondicion(e) && c2.cumpleCondicion(e);
    }
}
