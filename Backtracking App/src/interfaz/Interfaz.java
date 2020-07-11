package interfaz;

import estado.Estado;
import interfaz.actionListeners.SiguientesEstadosActionListener;
import poda.Poda;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

@SuppressWarnings("all")
public class Interfaz {
    private JButton verSiguientesEstadosButton;
    private JButton volverAlEstadoAnteriorButton;
    private JPanel panelPrincipal;
    private JPanel panelPrincipalB;
    private ButtonGroup grupoRadioButton;
    private Set<String> estadosAnteriores;
    private JFrame f;
    private Estado estadoSeleccionado;

    private final static int WIDTH = 800;
    private final static int HEIGHT = 800;

    public Interfaz(Estado inicial, Poda poda){
        grupoRadioButton = new ButtonGroup();
        f = new JFrame("Backtracking App");

        volverAlEstadoAnteriorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        verSiguientesEstadosButton.addActionListener(new SiguientesEstadosActionListener(inicial, poda, this));
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

    public Set<String> getEstadosAnteriores() {
        return estadosAnteriores;
    }

    public void setEstadosAnteriores(Set<String> estadosAnteriores) {
        this.estadosAnteriores = estadosAnteriores;
    }

    public Estado getEstadoSeleccionado() {
        return estadoSeleccionado;
    }

    public void setEstadoSeleccionado(Estado estadoSeleccionado) {
        this.estadoSeleccionado = estadoSeleccionado;
    }

    public void showInterface(Estado estado, Poda poda, Set<String> content) {
        f.setSize(this.WIDTH,this.HEIGHT); //tamaño inicial
        this.setEstadosAnteriores(content);
        Interfaz interfaz = new Interfaz(estado, poda);

        for (String e : content)
            interfaz.addContentToPanel(estado, poda, e);

        f.setContentPane(interfaz.getPanelPrincipal());
        f.setVisible(Boolean.TRUE);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void addContentToPanel(Estado estado, Poda poda, String content) {
        JRadioButton radioButton = new JRadioButton(content);
        radioButton.setOpaque(Boolean.TRUE);
        radioButton.setLayout(new GridBagLayout());

        radioButton.addActionListener(new SiguientesEstadosActionListener(estado, poda, this));

        JPanel panelLabel = new JPanel();
        panelLabel.add(radioButton);
        panelLabel.setBorder(new BevelBorder(1));

        this.grupoRadioButton.add(radioButton);

        panelPrincipalB.add(panelLabel, new GridBagConstraints());
    }

    public void showNuevosEstados(Estado estado, Poda poda, Set<String> nuevosEstados) {
        panelPrincipalB.removeAll();
        panelPrincipalB.revalidate();
        panelPrincipalB.repaint();

        for (String e : nuevosEstados)
            this.addContentToPanel(estado, poda, e);

        this.addContentToPanel(estado, poda, "Panel prueba");
    }

}
