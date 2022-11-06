package main.java.ui;

import main.java.domain.Playlist;

import javax.swing.*;
import java.awt.*;


public class PnlPelis extends JPanel {
    private Color color;
    private Playlist playlist;
    private Boton btnPlaylist;

    private JLabel lblNombrePlaylist;
    private JVentana ventana;
    private CardLayout cardsPelis;

    private JPanel pnlInterno;

    //poner el mismo que cards media

    private static final Color LBL_COLOR = new Color(183, 179, 179);
    public PnlPelis(Playlist playlist, JVentana ventana){ //pondrias un Jventa aqui?
        super(new BorderLayout());
        this.playlist=playlist;
        this.ventana= ventana;

        initPanel();
    }
    public void initPanel(){
       // setBackground(color); //en vez de color ponemos la imagen de la película
        //add(new JLabel(playlist.getNombre()));

        pnlInterno= new JPanel(new BorderLayout());
        //lo hacemos aqui no no en el bucle?
        setBackground(JVentana.R_BACKGROUND_COLOR);
        btnPlaylist = new Boton("",Color.WHITE,new ImageIcon("src/main/resources/musica-modified2.png"));
        btnPlaylist.delBackground();
        btnPlaylist.addHoverEffect();
        btnPlaylist.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));
        pnlInterno.add(btnPlaylist,BorderLayout.WEST);
        pnlInterno.setBackground(JVentana.R_BACKGROUND_COLOR);
        lblNombrePlaylist= new JLabel(playlist.getNombre());
        lblNombrePlaylist.setForeground(LBL_COLOR);
        lblNombrePlaylist.setBorder(BorderFactory.createEmptyBorder(10, 45, 0, 25));
        pnlInterno.add(lblNombrePlaylist,BorderLayout.SOUTH);

        //como poner el cards
        btnPlaylist.addActionListener(e->{
                PanelInternoPlaylist pnlInternoPlaylist= new PanelInternoPlaylist(ventana,new BorderLayout(),playlist);
                ventana.getCardsPerfil().show(ventana.getPnlCentralPerfil(),"Interno");
        });
        //add(new JLabel(playlist.getId_playlist()));
        //add(new JLabel(pelicula.getPlataforma()));
        add(pnlInterno);


    }

}
