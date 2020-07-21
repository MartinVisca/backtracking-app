package backtracking;

import estado.Estado;
import interfaz.Interfaz;
import poda.Poda;

import java.util.HashMap;

/**
 * Clase que engloba el comportamiento total de la librería.
 */
@SuppressWarnings("all")
public class Backtracking {

    private Poda poda;
    private Estado estado;

    public Backtracking(Estado estado, Poda poda) {
        this.estado = estado;
        this.poda = poda;
    }

    public void iniciar() {
        HashMap<String, Estado> estados = new HashMap<>();
        estados.put(estado.toString(), estado);

        Interfaz interfaz = new Interfaz(poda);
        interfaz.showInterface(poda, estados);
    }

}
