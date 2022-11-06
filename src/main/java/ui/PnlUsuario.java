package main.java.ui;

import javax.swing.*;
import java.awt.*;

public class PnlUsuario extends JPanel {

    private JPanel pnlImagen;
    private JPanel pnlInfo;
    private JPanel pnlOpciones;

    private JVentana ventana;

    private static final Color LBL_COLOR = new Color(183, 179, 179);

    public PnlUsuario(JVentana ventana, LayoutManager layoutManager){
        super(layoutManager);

        this.ventana = ventana;

        initPnlImagen();
        initPnlInfo();
        initPnlOpciones();
    }

    public void initPnlImagen(){
        pnlImagen = new JPanel();

        JLabel lblImagen = new JLabel();
        lblImagen.setIcon(new ImageIcon("src/main/resources/perfil.png"));
        pnlImagen.setBackground(JVentana.R_BACKGROUND_COLOR);
        pnlImagen.add(lblImagen);
        pnlImagen.setBorder(BorderFactory.createEmptyBorder(25, 25, 0, 25)); //Añado más márgen por la derecha e izquierda


        add(pnlImagen, BorderLayout.WEST);
    }

    public void initPnlInfo(){
        pnlInfo = new JPanel();

        pnlInfo.setBackground(JVentana.R_BACKGROUND_COLOR);
        pnlInfo.setBorder(BorderFactory.createEmptyBorder(70, 0, 0, 0)); //Añado más margen por arriba

        JLabel lblUsuario = new JLabel("migueltorresvalls");
        lblUsuario.setForeground(LBL_COLOR);
        lblUsuario.setFont(new Font(JVentana.FONT_LBL, Font.ITALIC, 12));

        Boton btnConfiguracion = new Boton("Configuracion", LBL_COLOR, new ImageIcon("src/main/resources/gearIcon.png"));
        btnConfiguracion.delBackground();
        btnConfiguracion.addHoverEffect();
        btnConfiguracion.setStyle(new Font(JVentana.FONT_LBL, Font.PLAIN, JVentana.LBL_SIZE));

        pnlInfo.add(lblUsuario);
        pnlInfo.add(Box.createRigidArea(new Dimension(50,0))); //Añado separación entre nombre usuario y configuración
        pnlInfo.add(btnConfiguracion);

        add(pnlInfo);
    }

    public void initPnlOpciones(){
        pnlOpciones = new JPanel();
        pnlOpciones.setBackground(JVentana.R_BACKGROUND_COLOR);
        pnlOpciones.setBorder(BorderFactory.createMatteBorder(0,0,1,0,LBL_COLOR));

        Boton btnPlaylist = new Boton("Playlist", LBL_COLOR, new ImageIcon("src/main/resources/playlistIcon.png"));
        btnPlaylist.delBackground();
        btnPlaylist.addHoverEffect();
        btnPlaylist.setStyle(new Font(JVentana.FONT_LBL, Font.PLAIN, JVentana.LBL_SIZE));
        btnPlaylist.addActionListener(e -> {
            ventana.getCardsMedia().show(ventana.getPnlMedia(), "playlist");
        });

        Boton btnReviews = new Boton("Reviews", LBL_COLOR, new ImageIcon("src/main/resources/pencilIcon.png"));
        btnReviews.delBackground();
        btnReviews.addHoverEffect();
        btnReviews.setStyle(new Font(JVentana.FONT_LBL, Font.PLAIN, JVentana.LBL_SIZE));
        btnReviews.addActionListener(e -> {
            ventana.getCardsMedia().show(ventana.getPnlMedia(), "reviews");
        });

        pnlOpciones.add(btnPlaylist);
        pnlOpciones.add(btnReviews);

        add(pnlOpciones, BorderLayout.SOUTH);
    }

}
