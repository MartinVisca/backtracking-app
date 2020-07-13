package interfaz.actionListeners;

import estado.Estado;
import interfaz.Interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadioButtonActionListener implements ActionListener {

    private Estado estado;
    private Interfaz interfaz;

    public RadioButtonActionListener(Estado estado, Interfaz interfaz) {
        this.estado = estado;
        this.interfaz = interfaz;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        interfaz.setEstadoSeleccionado(estado);
    }

}
