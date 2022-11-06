package main.java.ui;

import main.java.controler.GestorBD;
import main.java.dao.ConexionBD;
import main.java.dao.ConnectionDAO;
import main.java.domain.Pelicula;
import main.java.domain.Playlist;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class PnlPlayList extends JPanel {

    public static final Color BTN_COLOR = new Color(43, 131, 120);
    private Boton btnPlaylist;
    private JVentana ventana;

    private GestorBD gestorBD;

    public PnlPlayList(GestorBD gestorBD, JVentana ventana){
        this.gestorBD = gestorBD;
        this.ventana=ventana;
        setLayout(new BorderLayout());  //playlist
        setBackground(JVentana.R_BACKGROUND_COLOR);

        initPnls();

    }

    public void initPnls(){


        ArrayList<Playlist> listas_playlist = new ArrayList<>();

        /*
        CustomerDAO.getPlaylist(listas_playlist);
        JPanel panelMovieList= new JPanel(new GridLayout(3,3)); //layout por defecto ahora
        panelMovieList.setBackground(JVentana.R_BACKGROUND_COLOR);

        listas_playlist.forEach(p->{
            PnlPelis pnlPelis = new PnlPelis(p, colorRandom());
            //btnPlaylist= new Boton();
            //ventana.getCardsPerfil().show(ventana.getPnlCentralPerfil(), "centralUsuario
            //añadir boton aqui
            //boton.add action listener creas nuevo panel

            panelMovieList.add(pnlPelis);

        });

         */

        JPanel panelMovieList= new JPanel(new GridLayout(3,3)); //layout por defecto ahora
        panelMovieList.setBackground(JVentana.R_BACKGROUND_COLOR);

        gestorBD.getPlaylists().forEach(p->{
            PnlPelis pnlPelis = new PnlPelis(p,ventana);
            //btnPlaylist= new Boton();
            //ventana.getCardsPerfil().show(ventana.getPnlCentralPerfil(), "centralUsuario
            //añadir boton aqui
            //boton.add action listener creas nuevo panel

            panelMovieList.add(pnlPelis);

        });
        JScrollPane scrollMovieList = new JScrollPane(panelMovieList, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollMovieList.getVerticalScrollBar().setBackground(JVentana.R_BACKGROUND_COLOR);
        scrollMovieList.getVerticalScrollBar().setUnitIncrement(20);
        scrollMovieList.getVerticalScrollBar().setUI(new CustomScrollBarUI());
        scrollMovieList.getVerticalScrollBar().setPreferredSize(new Dimension(10,0));

        scrollMovieList.setFocusable(false);
        scrollMovieList.setBorder(null);


        add(scrollMovieList,BorderLayout.CENTER);
    }

    public Color colorRandom(){
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        Color randomColor = new Color(r, g, b);
        return randomColor;
    }
}

