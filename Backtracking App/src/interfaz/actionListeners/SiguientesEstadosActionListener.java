package interfaz.actionListeners;

import estado.Estado;
import interfaz.Interfaz;
import poda.Poda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SiguientesEstadosActionListener implements ActionListener {

    private Estado estado;
    Interfaz interfaz;
    Poda poda;

    public SiguientesEstadosActionListener(Estado estado, Poda poda, Interfaz interfaz) {
        this.estado = estado;
        this.interfaz = interfaz;
        this.poda = poda;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        interfaz.showNuevosEstados(estado, poda, estado.backtracking(poda));
    }

}
