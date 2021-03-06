package interfaz.actionListeners;

import estado.Estado;
import interfaz.Interfaz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que ejecuta la acción del botón de la interfaz "Estados anteriores". Implementa la interfaz ActionListener.
 */
@SuppressWarnings("all")
public class EstadosAnterioresActionListener implements ActionListener {

    private Interfaz interfaz;
    private Estado estado;

    public EstadosAnterioresActionListener(Estado estado, Interfaz interfaz) {
        this.interfaz = interfaz;
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            interfaz.showNuevosEstados(this.estado.getEstadoPadre(), this.estado.getEstadosHermanos());
        } catch(Exception exception) {
            JOptionPane.showMessageDialog(null,"Sin estados anteriores.");
        }
    }

}
