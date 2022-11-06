package main.java.ui;

import main.java.domain.Pelicula;
import main.java.domain.Playlist;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelInternoPlaylist extends JPanel {
    private JPanel pnlInfoPlaylist;
    private JPanel pnlPeliculas;
    private JPanel pnlInfoTotal;
    private JPanel pnlTextoBuscar;
    private JPanel pnlImagenPlaylist;

    private PnlFeed pnlFeed;

    private ArrayList<Pelicula> peliculas;

    private JPanel pnlBucasPeliculas;

    private JVentana ventana;
    private Playlist playlist;

    private CardLayout cards;

    private static final Color LBL_COLOR = new Color(183, 179, 179);
    public PanelInternoPlaylist(JVentana ventana,LayoutManager layoutManager,Playlist playlist){ //hay que meter si o si las playlist aqui y como las pillas
        super(layoutManager);
        //como pongo el cards entonces? no me deja poner otro super
        this.playlist=playlist;
        ventana.getPnlCentralPerfil().add(this, "Interno");
        initPnlInternoPeliculas();
        initPnlPeliculas();
        initBuscarPeliculas();

    }

    public void initPnlInternoPeliculas(){
        pnlInfoPlaylist= new JPanel();
        pnlInfoPlaylist.setBackground(JVentana.R_BACKGROUND_COLOR);


        pnlImagenPlaylist = new JPanel();
        pnlImagenPlaylist.setBackground(JVentana.R_BACKGROUND_COLOR);
        pnlInfoTotal= new JPanel(new BorderLayout());
        pnlInfoTotal.setBackground(JVentana.R_BACKGROUND_COLOR);
        pnlInfoTotal.setBorder(BorderFactory.createMatteBorder(0,0,3,0,LBL_COLOR));



        JLabel lblPlaylist = new JLabel(playlist.getNombre()); //nombre de la playlist;
        lblPlaylist.add(Box.createRigidArea(new Dimension(80,0)));
        lblPlaylist.setForeground(LBL_COLOR);
        lblPlaylist.setFont(new Font(JVentana.FONT_LBL, Font.BOLD, 15));
        lblPlaylist.setBorder(BorderFactory.createEmptyBorder(10, 25, 0, 25));


        JLabel lblImagen = new JLabel();
        lblImagen.setIcon(new ImageIcon("src/main/resources/music.png"));
        lblImagen.setBorder(BorderFactory.createEmptyBorder(10, 25, 0, 50));
        pnlImagenPlaylist.add(lblImagen);
        pnlImagenPlaylist.setBorder(BorderFactory.createEmptyBorder(25, 0, 0, 50)); //Añado más márgen por la derecha e izquierda


        //pnlTitulo.add(Box.createRigidArea(new Dimension(50,0))); //Añado separación entre nombre usuario y configuración
        //pnlTitulo.add("migueltorresvalls"); se añade el nombre del usuario

        pnlInfoPlaylist.add(pnlImagenPlaylist,BorderLayout.WEST);
        pnlInfoPlaylist.add(lblPlaylist,BorderLayout.CENTER);
        pnlInfoTotal.add(pnlInfoPlaylist,BorderLayout.NORTH);
        add(pnlInfoTotal,BorderLayout.NORTH);


    }


    public void initPnlPeliculas(){
        pnlPeliculas= new JPanel();
        pnlPeliculas.setBackground(JVentana.R_BACKGROUND_COLOR);
        pnlPeliculas.setBorder(BorderFactory.createEmptyBorder(70, 0, 0, 0)); //Añado más margen por arriba


        add(pnlPeliculas,BorderLayout.CENTER);

        JScrollPane scrollMovies = new JScrollPane(pnlPeliculas, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollMovies.getVerticalScrollBar().setBackground(JVentana.R_BACKGROUND_COLOR);
        scrollMovies.getVerticalScrollBar().setUnitIncrement(20);
        scrollMovies.getVerticalScrollBar().setUI(new CustomScrollBarUI());
        scrollMovies.getVerticalScrollBar().setPreferredSize(new Dimension(10,0));

        scrollMovies.setFocusable(false);
        scrollMovies.setBorder(null);


        add(scrollMovies,BorderLayout.CENTER);

    }

    public void initBuscarPeliculas(){
        pnlBucasPeliculas = new JPanel();
        pnlBucasPeliculas.setBackground(JVentana.R_BACKGROUND_COLOR);

        //esta por hacer:

       /* pnlTextoBuscar= new JPanel();

        Texto txtBuscar = new Texto(20, JVentana.LBL_COLOR, JVentana.R_BACKGROUND_COLOR);
        pnlTextoBuscar.add(txtBuscar);
        Boton btnBusqueda = new Boton("Buscar", Color.WHITE);
        btnBusqueda.delBackground();
        btnBusqueda.addHoverEffect();
        btnBusqueda.setStyle(new Font(JVentana.FONT_LBL, Font.PLAIN, JVentana.LBL_SIZE));

        btnBusqueda.addActionListener(e -> {
            String txtBuscado = txtBuscar.getText().trim();

            ArrayList<Cliente> clientes = ventana.getGClientes().buscarClientes(txtBuscado);
            ArrayList<Pelicula> peliculas = ventana.getGClientes().buscarPelicula(txtBuscado);

            if (clientes.size() > 0 || peliculas.size() > 0){
                System.out.println("Busqueda realizada con exito");

                pnlFeed = new PnlFeed(this, clientes, peliculas);
                //pnlFeed.setLayout(new WrapLayout());
                pnlFeed.setLayout(new BoxLayout(pnlFeed, BoxLayout.Y_AXIS));


                JScrollPane pnlScrollFeed = new JScrollPane(pnlFeed, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);


                pnlScrollFeed.getVerticalScrollBar().setBackground(JVentana.R_BACKGROUND_COLOR);
                pnlScrollFeed.getVerticalScrollBar().setUnitIncrement(20);
                pnlScrollFeed.getVerticalScrollBar().setUI(new CustomScrollBarUI());
                pnlScrollFeed.getVerticalScrollBar().setPreferredSize(new Dimension(10,0));


                pnlScrollFeed.setFocusable(false);
                pnlScrollFeed.setBorder(null);

               pnlBucasPeliculas.add(pnlScrollFeed,BorderLayout.CENTER);

            } else{
                JOptionPane.showMessageDialog(ventana, "No se han encontrado resultados para la busqueda");

            }
        });*/


        /*JScrollPane scrollBuscar = new JScrollPane(pnlBucasPeliculas, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollBuscar.getVerticalScrollBar().setBackground(JVentana.R_BACKGROUND_COLOR);
        scrollBuscar.getVerticalScrollBar().setUnitIncrement(20);
        scrollBuscar.getVerticalScrollBar().setUI(new CustomScrollBarUI());
        scrollBuscar.getVerticalScrollBar().setPreferredSize(new Dimension(10,0));

        scrollBuscar.setFocusable(false);
        scrollBuscar.setBorder(null);


        add(scrollBuscar,BorderLayout.CENTER);*/

        add(pnlBucasPeliculas,BorderLayout.SOUTH);

    }

}
