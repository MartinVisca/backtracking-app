package interfaz.actionListeners;

import estado.Estado;
import interfaz.Interfaz;
import poda.Poda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que ejecuta la acción del botón de la interfaz "Estados siguientes". Implementa la interfaz ActionListener.
 */
@SuppressWarnings("all")
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

        if (estado != null)
            interfaz.showNuevosEstados(estado, estado.backtracking(poda));
        else
            JOptionPane.showMessageDialog(null,"No seleccionaste ningún estado");
    }

}
