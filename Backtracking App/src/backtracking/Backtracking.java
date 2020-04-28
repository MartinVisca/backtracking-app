package backtracking;

import estado.Estado;
import poda.Poda;

public class Backtracking {
    /**
     *  Clase que engloba el comportamiento total de la librería.
     **/

    private Poda poda;

    public Backtracking(Poda poda) {
        this.poda = poda;
    }

    public void iniciar(Estado inicial) {
        //Acá también se inicia la interfaz.
        inicial.backtracking(this.poda);
    }

    public void avanzar(Estado siguiente) {
        //Con la interfaz ya iniciada, va mostrando los estados que resultan de cada ejecución del algoritmo.
        siguiente.backtracking(this.poda);
    }

}
