package main.java.ui;

import main.java.controler.GestorBD;
import main.java.dao.ConexionBD;
import main.java.dao.ConnectionDAO;

import javax.swing.*;
import java.awt.*;

public class JVentana extends JFrame {

    private GestorBD gClientes = new GestorBD(new ConexionBD(ConnectionDAO.getInstance().getConnection()));
    public static final Color BACKGROUND_COLOR = new Color(51, 46, 46);
    public static final Color R_BACKGROUND_COLOR = new Color(72, 64, 64);

    public static final Color LBL_COLOR = new Color(190, 176, 176);
    public static final Color BTN_COLOR = new Color(43, 131, 120);
    public static final String FONT_LBL = "Lato";
    public static final int LBL_SIZE = 15;

    private CardLayout cardsPerfil;
    private CardLayout cards;
    private CardLayout cardsMedia;

    private JPanel pnlTodo;
    private JPanel pnlCentralPerfil;
    private JPanel pnlMedia;

    private PnlPlayList pnlPlaylist;

    public static final int ANCHURA = 900;
    public static final int ALTURA = 1000;

    public JVentana(){
        super("MovieGram");

        cards = new CardLayout();
        pnlTodo = new JPanel(cards);

        //Inicio sesión
        //pnlCentral
        JPanel pnlCentral = new JPanel(new GridLayout(2,1));

        //pnlInicio
        PnlInicio pnlInicio = new PnlInicio(new CardLayout(), gClientes, this);

        //pnlLogo
        PnlLogo pnlLogo = new PnlLogo();
        int anchoImagen = 250;
        int altoImagen = 250;
        pnlLogo.addImagen(new Imagen("src/main/resources/logo.png", ANCHURA/2 - (anchoImagen/2),150, anchoImagen, altoImagen));

        pnlCentral.add(pnlLogo);
        pnlCentral.add(pnlInicio);


        //Perfil
        JPanel pnlPerfil = new JPanel(new BorderLayout());

        //pnlCentral
        cardsPerfil = new CardLayout();
        pnlCentralPerfil = new JPanel(cardsPerfil);

        //pnlCentralUsuario
        JPanel pnlCentralUsuario = new JPanel(new BorderLayout());
        pnlCentralPerfil.add(pnlCentralUsuario, "centralUsuario");

        //pnlUsuario
        PnlUsuario pnlUsuario = new PnlUsuario(this, new BorderLayout());
        pnlUsuario.setBackground(R_BACKGROUND_COLOR);

        pnlCentralUsuario.add(pnlUsuario, BorderLayout.NORTH);


        //pnlMedia
        cardsMedia = new CardLayout();
        pnlMedia = new JPanel(cardsMedia);
        pnlCentralUsuario.add(pnlMedia);

        //pnlPlayList
        pnlPlaylist = new PnlPlayList(gClientes,this);
        pnlPlaylist.setBackground(R_BACKGROUND_COLOR);
        pnlMedia.add(pnlPlaylist, "playlist");

        //pnlReviews
        PnlReviews pnlReviews = new PnlReviews();
        pnlReviews.setBackground(R_BACKGROUND_COLOR);
        pnlMedia.add(pnlReviews, "reviews");

        cardsMedia.show(pnlMedia, "playlist");


        //pnlBusqueda
        /*
        PnlBuscar pnlBusqueda = new PnlBuscar(this, new GridBagLayout());

        pnlBusqueda.initComponentes();
        pnlCentralPerfil.add(pnlBusqueda, "centralBusqueda");

         */
        PnlBusqueda pnlBusqueda = new PnlBusqueda(this, new BorderLayout());

        pnlCentralPerfil.add(pnlBusqueda, "centralBusqueda");

        PnlnewPlaylist pnlnewPlaylist= new PnlnewPlaylist(this,gClientes);
        //pnlnewPlaylist.initComponentes();
        pnlCentralPerfil.add(pnlnewPlaylist,"centralPlaylist");

        //PanelInternoPlaylist pnlInterno = //añadirlo a pnlCentralPERFIL




        //pnlWest
        PnlWest pnlWest = new PnlWest(this);
        pnlWest.setLayout(new BoxLayout(pnlWest, BoxLayout.Y_AXIS));

        pnlWest.add(Box.createRigidArea(new Dimension(20, 300)));
        pnlWest.initComponentes(new Dimension(20,15));


        cardsPerfil.show(pnlCentralPerfil, "centralUsuario");

        pnlPerfil.add(pnlCentralPerfil);
        pnlPerfil.add(pnlWest, BorderLayout.WEST);


        //pnlTodo
        pnlTodo.add(pnlCentral, "inicioSesion");
        pnlTodo.add(pnlPerfil, "perfil");
        cards.show(pnlTodo, "inicioSesion");


        //JFrame
        add(pnlTodo);



        setSize(ANCHURA,ALTURA);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public PnlPlayList getPnlPlaylist(){
        return pnlPlaylist;
    }

    public GestorBD getGClientes(){
        return gClientes;
    }

    public JPanel getPnlTodo(){
        return pnlTodo;
    }

    public JPanel getPnlMedia(){
        return pnlMedia;
    }

    public CardLayout getCards(){
        return cards;
    }

    public CardLayout getCardsPerfil(){
        return cardsPerfil;
    }

    public CardLayout getCardsMedia(){
        return cardsMedia;
    }

    public JPanel getPnlCentralPerfil(){
        return pnlCentralPerfil;
    }

    public static void main(String[] args) {
        new JVentana();

    }
}
