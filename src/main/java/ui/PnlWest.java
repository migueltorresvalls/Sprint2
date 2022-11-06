package main.java.ui;

import javax.swing.*;
import java.awt.Button;
import java.awt.*;

public class PnlWest extends JPanel {

    private Boton btnInicio;
    private Boton btnExplorar;
    private Boton btnMensajes;
    private Boton btnCrearPlaylist;

    private JVentana ventana;

    public PnlWest(JVentana perfil){
        super();

        this.ventana = perfil;

        setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 25)); //Añado más márgen por la derecha
        setBackground(JVentana.BACKGROUND_COLOR);
    }

    public void initComponentes(Dimension separacion){
        btnInicio = new Boton("Inicio", JVentana.LBL_COLOR, new Color(239, 221, 221), new ImageIcon("src/main/resources/homeIcon.png"), new ImageIcon("src/main/resources/homeIconHover.png"));
        btnExplorar = new Boton("Explorar", JVentana.LBL_COLOR, new Color(239, 221, 221), new ImageIcon("src/main/resources/searchIcon.png"), new ImageIcon("src/main/resources/searchIconHover.png"));
        btnMensajes = new Boton("Mensajes", JVentana.LBL_COLOR, new Color(239, 221, 221), new ImageIcon("src/main/resources/messageIcon.png"), new ImageIcon("src/main/resources/messageIconHover.png"));
        btnCrearPlaylist = new Boton("Añadir playlist", JVentana.LBL_COLOR, new Color(239, 221, 221), new ImageIcon("src/main/resources/createIcon.png"), new ImageIcon("src/main/resources/createIconHover.png"));

        btnInicio.delBackground();
        btnInicio.addHoverEffect();
        btnInicio.setStyle(new Font(JVentana.FONT_LBL, Font.PLAIN, JVentana.LBL_SIZE));
        btnInicio.addActionListener(e -> {
            ventana.getCardsPerfil().show(ventana.getPnlCentralPerfil(), "centralUsuario");
        });
        add(btnInicio);

        add(Box.createRigidArea(separacion));
        btnExplorar.delBackground();
        btnExplorar.addHoverEffect();
        btnExplorar.setStyle(new Font(JVentana.FONT_LBL, Font.PLAIN, JVentana.LBL_SIZE));
        btnExplorar.addActionListener(e -> {
            ventana.getCardsPerfil().show(ventana.getPnlCentralPerfil(), "centralBusqueda");
        });
        add(btnExplorar);

        add(Box.createRigidArea(separacion));
        btnMensajes.delBackground();
        btnMensajes.addHoverEffect();
        btnMensajes.setStyle(new Font(JVentana.FONT_LBL, Font.PLAIN, JVentana.LBL_SIZE));
        add(btnMensajes);

        add(Box.createRigidArea(separacion));
        btnCrearPlaylist.delBackground();
        btnCrearPlaylist.addHoverEffect();
        btnCrearPlaylist.setStyle(new Font(JVentana.FONT_LBL, Font.PLAIN, JVentana.LBL_SIZE));
        btnCrearPlaylist.addActionListener(e -> {
            ventana.getCardsPerfil().show(ventana.getPnlCentralPerfil(), "centralPlaylist");
        });
        add(btnCrearPlaylist);
    }
}

