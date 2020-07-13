package interfaz.actionListeners;

import estado.Estado;
import interfaz.Interfaz;
import poda.Poda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SiguientesEstadosActionListener implements ActionListener {

    private Interfaz interfaz;
    private Poda poda;

    public SiguientesEstadosActionListener(Poda poda, Interfaz interfaz) {
        this.interfaz = interfaz;
        this.poda = poda;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Estado estado = interfaz.getEstadoSeleccionado();
        interfaz.showNuevosEstados(estado, poda, estado.backtracking(poda));
    }

}
