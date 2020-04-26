package impresor;

import estructura.Estructura;

import javax.swing.*;

@SuppressWarnings("unused")
public class Impresor {
    /**
     *  Encargada de realizar lo relacionado a la impresión por pantalla de las diferentes estructuras y estados.
     **/

    private final static int ANCHO_VENTANA_APLICACION = 250;
    private final static int LARGO_VENTANA_APLICACION = 200;

    public Impresor() {
        this.inicializarInterfaz();
    }

    private void inicializarInterfaz() {
        JFrame frame = new JFrame();
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setBounds(ANCHO_VENTANA_APLICACION, ANCHO_VENTANA_APLICACION, LARGO_VENTANA_APLICACION, LARGO_VENTANA_APLICACION);
    }

    public void agregarElementoAMostrar() {

    }

    public void imprimir(Estructura e) {
    }

}
