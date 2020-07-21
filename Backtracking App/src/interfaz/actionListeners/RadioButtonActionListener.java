package interfaz.actionListeners;

import estado.Estado;
import interfaz.Interfaz;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que ejecuta la acción producida por la selección de un radio button. Implementa la interfaz ActionListener.
 */
@SuppressWarnings("all")
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
