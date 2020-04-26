package impresor;

import estructura.Estructura;

import javax.swing.*;

public class Impresor {
    /**
     *  Encargada de realizar lo relacionado a la impresión por pantalla de las diferentes estructuras y estados.
     **/

    private JFrame frame;
    private JPanel panelPrincipal;

    private final static int ANCHO_VENTANA_APLICACION = 250;
    private final static int LARGO_VENTANA_APLICACION = 200;

    public Impresor() {
        this.inicializarInterfaz();
    }

    private void inicializarInterfaz() {
        this.frame = new JFrame();
        this.panelPrincipal = new JPanel();
        panelPrincipal.setBounds(this.ANCHO_VENTANA_APLICACION,this.ANCHO_VENTANA_APLICACION, this.LARGO_VENTANA_APLICACION, this.LARGO_VENTANA_APLICACION);
    }

    public void agregarElementoAMostrar() {

    }

    public void imprimir(Estructura e) {
    }

}
