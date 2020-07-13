package interfaz;

import estado.Estado;
import interfaz.actionListeners.RadioButtonActionListener;
import interfaz.actionListeners.SiguientesEstadosActionListener;
import poda.Poda;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

@SuppressWarnings("all")
public class Interfaz {
    private JButton verSiguientesEstadosButton;
    private JButton volverAlEstadoAnteriorButton;
    private JPanel panelPrincipal;
    private JPanel panelPrincipalB;
    private ButtonGroup grupoRadioButton;
    private HashMap<String, Estado> estadosAnteriores;
    private JFrame frame;
    private Estado estadoSeleccionado;

    private final static int WIDTH = 1200;
    private final static int HEIGHT = 1000;

    public Interfaz(Poda poda){
        grupoRadioButton = new ButtonGroup();
        frame = new JFrame("Backtracking App");

        volverAlEstadoAnteriorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

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

    public HashMap<String, Estado> getEstadosAnteriores() {
        return estadosAnteriores;
    }

    public void setEstadosAnteriores(HashMap<String, Estado> estadosAnteriores) {
        this.estadosAnteriores = estadosAnteriores;
    }

    public Estado getEstadoSeleccionado() {
        return estadoSeleccionado;
    }

    public void setEstadoSeleccionado(Estado estadoSeleccionado) {
        this.estadoSeleccionado = estadoSeleccionado;
    }

    public void showInterface(Poda poda, HashMap<String, Estado> content) {
        frame.setSize(this.WIDTH, this.HEIGHT); //tamaño inicial
        this.setEstadosAnteriores(content);
        Interfaz interfaz = new Interfaz(poda);

        if(content.isEmpty())
            interfaz.addContentToPanel(null, poda, "Sin estados");
        else
            for (String e : content.keySet())
            interfaz.addContentToPanel(content.get(e), poda, e);

        frame.setContentPane(interfaz.getPanelPrincipal());
        frame.setVisible(Boolean.TRUE);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void addContentToPanel(Estado estado, Poda poda, String content) {
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

    public void showNuevosEstados(Estado estado, Poda poda, HashMap<String, Estado> nuevosEstados) {
        panelPrincipalB.removeAll();
        panelPrincipalB.revalidate();
        panelPrincipalB.repaint();

        if (nuevosEstados.isEmpty())
            this.addContentToPanel(estado, poda, "Sin estados");
        else
            for (Estado e : nuevosEstados.values())
                this.addContentToPanel(e, poda, e.toString());
    }

}
