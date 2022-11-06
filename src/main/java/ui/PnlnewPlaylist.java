package main.java.ui;

import main.java.controler.GestorBD;
import main.java.domain.Playlist;
import main.java.domain.PlaylistYaExistente;

import javax.swing.*;
import java.awt.*;

public class PnlnewPlaylist  extends JPanel {

    private JVentana ventana;
    private GestorBD gPlaylists;


    private GridBagConstraints gbc = new GridBagConstraints();

    public JLabel ftoPlaylist;
    public JLabel nombre;

    private CardLayout cards;
    public JLabel cambiarfoto;
    public JLabel id;




    public PnlnewPlaylist(JVentana ventana, GestorBD gPlaylists) {
        cards = new CardLayout();
        this.ventana=ventana;
        this.gPlaylists=gPlaylists;

        initComponentes();
    }
    public void initComponentes(){
        setLayout(new GridBagLayout());
        setBackground(JVentana.R_BACKGROUND_COLOR);
//        Boton cambiarFoto= new Boton("Cambiar Foto");


        setGbc(0,0,2,1);
        JLabel lblNuevaPlaylist = new JLabel("PLaylist");
        lblNuevaPlaylist.setForeground(JVentana.LBL_COLOR);
        add(lblNuevaPlaylist, gbc);

        setGbc(2,0,2,1);
        Texto txtNuevaPlaylist = new Texto(15, JVentana.LBL_COLOR, JVentana.R_BACKGROUND_COLOR);
        add(txtNuevaPlaylist, gbc);

        setGbc(0,1,2,1);
        JLabel lblNuevoID = new JLabel("ID ");
        lblNuevoID.setForeground(JVentana.LBL_COLOR);
        add(lblNuevoID, gbc);

        setGbc(2,1,2,1);
        Texto txtIdNuevo= new Texto(15, JVentana.LBL_COLOR, JVentana.R_BACKGROUND_COLOR);
        add(txtIdNuevo, gbc);

        setGbc(0, 3, 4, 1);
        Boton btnCrear = new Boton("Crear Movielist", JVentana.BTN_COLOR, new Color(239, 221, 221));
        btnCrear.delBackground();
        btnCrear.addHoverEffect();
        btnCrear.setForeground(JVentana.BTN_COLOR);
        add(btnCrear, gbc);
        btnCrear.addActionListener(e -> {

            try {
                    //gPlaylists.addPlaylist(new Playlist(txtNuevaPlaylist.getText(), txtIdNuevo.getText()));
                    gPlaylists.addPlaylist(new Playlist(Integer.parseInt(txtIdNuevo.getText()), txtNuevaPlaylist.getText()));
                    if (gPlaylists.getPlaylists().contains(new Playlist(Integer.parseInt(txtIdNuevo.getText()), txtNuevaPlaylist.getText()))) {
                        JOptionPane.showMessageDialog(ventana, "Playlist Creada");

                        ventana.getPnlPlaylist().initPnls();

                }else{
                    JOptionPane.showMessageDialog(ventana,"POnga nombre");
                }


            }catch(PlaylistYaExistente ex){
                JOptionPane.showMessageDialog(ventana, "Playlist ya existente");
            }


        });





    }

    public void init(){
        ftoPlaylist= new JLabel();
        ftoPlaylist.setIcon(new ImageIcon(new ImageIcon("src/main/resources/fotoperfil.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));

        cambiarfoto = new JLabel("cambiar");
        nombre = new JLabel("Name");
        nombre.setIconTextGap(7);
        nombre.setForeground(JVentana.LBL_COLOR);
        nombre.setFont(new Font(JVentana.FONT_LBL, Font.PLAIN, JVentana.LBL_SIZE));

    }
    private void setGbc(int gridX, int gridY, int gridWidth, int gridHeight){
        gbc.gridheight = gridHeight;
        gbc.gridwidth = gridWidth;
        gbc.gridx = gridX;
        gbc.gridy = gridY;
    }
}
