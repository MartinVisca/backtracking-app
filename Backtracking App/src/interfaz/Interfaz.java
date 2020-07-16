package interfaz;

import estado.Estado;
import interfaz.actionListeners.EstadosAnterioresActionListener;
import interfaz.actionListeners.RadioButtonActionListener;
import interfaz.actionListeners.SiguientesEstadosActionListener;
import poda.Poda;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.util.HashMap;

@SuppressWarnings("all")
public class Interfaz {
    private JButton verSiguientesEstadosButton;
    private JButton volverAlEstadoAnteriorButton;
    private JPanel panelPrincipal;
    private JPanel panelPrincipalB;
    private ButtonGroup grupoRadioButton;
    private JFrame frame;
    private Estado estadoSeleccionado;

    private final static int WIDTH = 1200;
    private final static int HEIGHT = 1000;
    private final static int FIRST_ELEMENT = 0;

    public Interfaz(Poda poda){
        grupoRadioButton = new ButtonGroup();
        frame = new JFrame("Backtracking App");
        volverAlEstadoAnteriorButton.addActionListener(new EstadosAnterioresActionListener(null, this));
        verSiguientesEstadosButton.addActionListener(new SiguientesEstadosActionListener(poda, this));
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public void setPanelPrincipal(JPanel panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
    }

    public JPanel getPanelPrincipalB() {
        return panelPrincipalB;
    }

    public void setPanelPrincipalB(JPanel panelPrincipalB) {
        this.panelPrincipalB = panelPrincipalB;
    }

    public ButtonGroup getGrupoRadioButton() {
        return grupoRadioButton;
    }

    public void setGrupoRadioButton(ButtonGroup grupoRadioButton) {
        this.grupoRadioButton = grupoRadioButton;
    }

    public Estado getEstadoSeleccionado() {
        return estadoSeleccionado;
    }

    public void setEstadoSeleccionado(Estado estadoSeleccionado) {
        this.estadoSeleccionado = estadoSeleccionado;
    }

    public void showInterface(Poda poda, HashMap<String, Estado> content) {
        frame.setSize(this.WIDTH, this.HEIGHT);
        Interfaz interfaz = new Interfaz(poda);

        if(content.isEmpty())
            interfaz.addContentToPanel(null, "Sin estados");
        else
            for (String e : content.keySet()) {
                content.get(e).setEstadosHermanos(content);
                content.get(e).setEstadoPadre(content.get(e));
                interfaz.addContentToPanel(content.get(e), e);
            }

        frame.setContentPane(interfaz.getPanelPrincipal());
        frame.setVisible(Boolean.TRUE);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void addContentToPanel(Estado estado, String content) {
        JPanel panelLabel = new JPanel();

        if (!content.equals("Sin estados")) {
            JRadioButton radioButton = new JRadioButton(content.toString());
            radioButton.setOpaque(Boolean.TRUE);
            radioButton.setLayout(new GridBagLayout());

            radioButton.addActionListener(new RadioButtonActionListener(estado, this));

            panelLabel.add(radioButton);
            this.grupoRadioButton.add(radioButton);
        }
        else {
            JLabel labelContentVacio = new JLabel("Sin mas estados que mostrar; la solución no pudo ser encontrada");
            labelContentVacio.setLayout(new GridBagLayout());
            panelLabel.add(labelContentVacio);
        }

        panelLabel.setBorder(new BevelBorder(1));
        panelPrincipalB.add(panelLabel, new GridBagConstraints());
    }

    public void showNuevosEstados(Estado estado, HashMap<String, Estado> nuevosEstados) {
        panelPrincipalB.removeAll();
        panelPrincipalB.revalidate();
        panelPrincipalB.repaint();

        ((EstadosAnterioresActionListener) volverAlEstadoAnteriorButton.getActionListeners()[this.FIRST_ELEMENT]).setEstado(estado);

        if (nuevosEstados.isEmpty())
            this.addContentToPanel(estado,"Sin estados");
        else
            for (Estado e : nuevosEstados.values()) {
                e.setEstadosHermanos(nuevosEstados);
                e.setEstadoPadre(estado);
                this.addContentToPanel(e, e.toString());
            }
    }

}
