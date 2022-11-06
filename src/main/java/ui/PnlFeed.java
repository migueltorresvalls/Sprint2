package main.java.ui;

import main.java.domain.Cliente;
import main.java.domain.Pelicula;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

public class PnlFeed extends JPanel {

    private ArrayList<Cliente> clientes;
    private ArrayList<Pelicula> peliculas;

    private JPanel pnlPadre;

    public PnlFeed(JPanel pnlPadre, ArrayList<Cliente> clientes, ArrayList<Pelicula> peliculas){
        super();

        this.pnlPadre = pnlPadre;
        this.clientes = clientes;
        this.peliculas = peliculas;

        setBackground(JVentana.R_BACKGROUND_COLOR);
        showFeed();
    }


    public void showFeed(){
        Random r = new Random();

        clientes.forEach(c -> {
            JPanel pnlCliente = new JPanel(new BorderLayout());
            //pnlCliente.setBackground(new Color(r.nextInt(255), 121, r.nextInt(255)));
            pnlCliente.setBackground(JVentana.R_BACKGROUND_COLOR);

            JLabel lblNombre = new JLabel(c.getNombre());
            lblNombre.setIcon(new ImageIcon("src/main/resources/perfil.png"));
            lblNombre.setForeground(Color.WHITE);

            Boton btnOpciones = new Boton("", Color.WHITE, new ImageIcon("src/main/resources/addMovie.png"));
            btnOpciones.delBackground();
            btnOpciones.addHoverEffect();

            pnlCliente.add(btnOpciones, BorderLayout.EAST);

            pnlCliente.add(lblNombre);
            System.out.println(c);

            add(pnlCliente);
        });
        peliculas.forEach(p -> {
            JPanel pnlPelicula = new JPanel(new BorderLayout());
            //pnlPelicula.setBackground(new Color(r.nextInt(255), 121, r.nextInt(255)));
            pnlPelicula.setBackground(JVentana.R_BACKGROUND_COLOR);

            Boton btnOpciones = new Boton("", Color.WHITE, new ImageIcon("src/main/resources/addMovie.png"));
            btnOpciones.delBackground();
            btnOpciones.addHoverEffect();
            btnOpciones.addActionListener(e -> {
                Object[] options = {"Agregar a playlist", "Valorar"};
                Object opcionElegida = JOptionPane.showInputDialog(pnlPadre, "Selecciona una opción", "OPCIONES", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                if (opcionElegida != null) {
                    if (opcionElegida.toString().equals(options[0].toString())) {
                        System.out.println("El nombre de la película seleccionada es: " + p.getNombre());
                    } else {
                        System.out.println("La url de la imagen es: " + p.getUrl());
                    }
                }
            });

            pnlPelicula.add(btnOpciones, BorderLayout.EAST);

            JLabel lblNombre = new JLabel(p.getNombre());
            lblNombre.setForeground(Color.WHITE);
            try {
                lblNombre.setIcon(new ImageIcon(new URL(p.getUrl())));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            pnlPelicula.add(lblNombre);
            System.out.println(p);

            add(pnlPelicula);
        });
    }
}
