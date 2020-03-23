package accion;

import estructura.Estructura;

public class AccionCompuesta implements Accion {
    /**Una de las posibles implementaciones de Accion. Esta clase da la utilidad de poder realizar mas de una posible accion con una
     * unica variable. **/

    private Accion a1;
    private Accion a2;

    public AccionCompuesta(){}

    public AccionCompuesta(Accion a1, Accion a2){
        this.a1 = a1;
        this.a2 = a2;
    }

    public Accion getA1() {
        return a1;
    }

    public Accion getA2() {
        return a2;
    }

    public void setA1(Accion a1) {
        this.a1 = a1;
    }

    public void setA2(Accion a2) {
        this.a2 = a2;
    }

    @Override
    public void realizarAccion(Estructura e, Object... parametros) {
        a1.realizarAccion(e, parametros);
        a2.realizarAccion(e, parametros);
    }
}
