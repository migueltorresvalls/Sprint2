package main.java.ui;

import main.java.domain.Cliente;
import main.java.domain.Pelicula;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.util.ArrayList;

public class PnlBusqueda extends JPanel {


    private JVentana ventana;

    private PnlFeed pnlFeed;

    private JPanel pnlCentralFeed;
    private CardLayout cardsFeed;

    public PnlBusqueda(JVentana ventana, LayoutManager layoutManager){
        super(layoutManager);

        this.ventana = ventana;
        initPnlNorte();
        initPnlCentral();
    }

    public void initPnlNorte(){
        JPanel pnlNorte = new JPanel();
        pnlNorte.setLayout(new BoxLayout(pnlNorte, BoxLayout.Y_AXIS));

        pnlNorte.setBackground(JVentana.R_BACKGROUND_COLOR);

        Texto txtBuscar = new Texto(30, JVentana.LBL_COLOR, JVentana.R_BACKGROUND_COLOR);
        pnlNorte.add(txtBuscar);


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

                pnlCentralFeed.add(pnlScrollFeed, "feed");

                cardsFeed.show(pnlCentralFeed, "feed");
            } else{
                JOptionPane.showMessageDialog(ventana, "No se han encontrado resultados para la busqueda");

                cardsFeed.show(pnlCentralFeed, "feedVacio");

            }
        });

        pnlNorte.add(btnBusqueda);

        add(pnlNorte, BorderLayout.NORTH);
    }

    private void initPnlCentral(){
        cardsFeed = new CardLayout();
        pnlCentralFeed = new JPanel(cardsFeed);

        JPanel pnlFeedVacio = new JPanel();
        pnlFeedVacio.setBackground(JVentana.R_BACKGROUND_COLOR);

        pnlCentralFeed.add(pnlFeedVacio, "feedVacio");

        cardsFeed.show(pnlCentralFeed, "feedVacio");

        add(pnlCentralFeed);

    }
}
