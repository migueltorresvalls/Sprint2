package main.java.ui;

import main.java.controler.GestorBD;
import main.java.domain.Cliente;
import main.java.domain.UsuarioYaExistente;

import javax.swing.*;
import java.awt.*;

public class PnlInicio extends JPanel {

    private GestorBD gClientes;
    private CardLayout cards;
    private GridBagConstraints gbc = new GridBagConstraints();

    private JVentana ventana;


    public PnlInicio(CardLayout cards, GestorBD gClientes, JVentana ventana){
        super(cards);

        this.gClientes = gClientes;
        this.cards = cards;
        this.ventana = ventana;

        initPnlInicioSesion();
        initPnlRegistro();
        initPnlRecuperacion();
    }

    public void initPnlInicioSesion(){
        JPanel pnlInicioSesion = new JPanel(new GridBagLayout());
        pnlInicioSesion.setBackground(JVentana.BACKGROUND_COLOR);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        setGbc(0,0,2,1);
        JLabel lblUsuario = new JLabel("Usuario ");
        lblUsuario.setForeground(JVentana.LBL_COLOR);
        pnlInicioSesion.add(lblUsuario, gbc);

        setGbc(2,0,2,1);
        Texto txtUsuario = new Texto(15, JVentana.LBL_COLOR, JVentana.BACKGROUND_COLOR);
        pnlInicioSesion.add(txtUsuario, gbc);

        setGbc(0,1,2,1);
        JLabel lblContra = new JLabel("Contraseña ");
        lblContra.setForeground(JVentana.LBL_COLOR);
        pnlInicioSesion.add(lblContra, gbc);

        setGbc(2,1,2,1);
        Texto pswContra = new Texto(15, JVentana.LBL_COLOR, JVentana.BACKGROUND_COLOR);
        pnlInicioSesion.add(pswContra, gbc);

        setGbc(0, 2, 4, 1);
        Boton btnNuevoUser = new Boton("Registrarse", JVentana.BTN_COLOR, new Color(239, 221, 221));
        btnNuevoUser.delBackground();
        btnNuevoUser.addHoverEffect();
        btnNuevoUser.setForeground(JVentana.BTN_COLOR);
        pnlInicioSesion.add(btnNuevoUser, gbc);
        btnNuevoUser.addActionListener(e -> cards.show(this, "registro"));

        setGbc(0,3,4,1);
        Boton btnContraOlvidada = new Boton("Recuperar contraseña", JVentana.BTN_COLOR, new Color(239, 221, 221));
        btnContraOlvidada.delBackground();
        btnContraOlvidada.addHoverEffect();
        btnContraOlvidada.setForeground(JVentana.BTN_COLOR);
        pnlInicioSesion.add(btnContraOlvidada, gbc);
        btnContraOlvidada.addActionListener(e -> cards.show(this, "recuperar"));

        setGbc(0,4,4,1);
        Boton btnLogin = new Boton("Iniciar sesión", JVentana.BTN_COLOR, new Color(239, 221, 221));
        btnLogin.delBackground();
        btnLogin.addHoverEffect();
        btnLogin.setForeground(JVentana.BTN_COLOR);
        pnlInicioSesion.add(btnLogin, gbc);
        btnLogin.addActionListener(e -> {
            if (gClientes.getClientes().contains(new Cliente(txtUsuario.getText(), pswContra.getText()))){
                Cliente cliente = gClientes.getCliente(txtUsuario.getText());
                System.out.println("---INICIO SESIÓN---\n" + cliente);
                ventana.getCards().show(ventana.getPnlTodo(), "perfil");

            }else {
                JOptionPane.showMessageDialog(ventana, "Usuario no encontrado");
            }
        });

        add(pnlInicioSesion, "inicioSesion");
        cards.show(this, "inicioSesion");
    }

    public void initPnlRegistro(){
        JPanel pnlRegistro = new JPanel(new GridBagLayout());
        pnlRegistro.setBackground(JVentana.BACKGROUND_COLOR);

        setGbc(0,0,2,1);
        JLabel lblNuevoUsuario = new JLabel("Usuario ");
        lblNuevoUsuario.setForeground(JVentana.LBL_COLOR);
        pnlRegistro.add(lblNuevoUsuario, gbc);

        setGbc(2,0,2,1);
        Texto txtNuevoUsuario = new Texto(15, JVentana.LBL_COLOR, JVentana.BACKGROUND_COLOR);
        pnlRegistro.add(txtNuevoUsuario, gbc);

        setGbc(0,1,2,1);
        JLabel lblNuevoCorreo = new JLabel("Correo ");
        lblNuevoCorreo.setForeground(JVentana.LBL_COLOR);
        pnlRegistro.add(lblNuevoCorreo, gbc);

        setGbc(2,1,2,1);
        Texto txtCorreoNuevo = new Texto(15, JVentana.LBL_COLOR, JVentana.BACKGROUND_COLOR);
        pnlRegistro.add(txtCorreoNuevo, gbc);

        setGbc(0,2,2,1);
        JLabel lblNuevaContra = new JLabel("Contraseña ");
        lblNuevaContra.setForeground(JVentana.LBL_COLOR);
        pnlRegistro.add(lblNuevaContra, gbc);

        setGbc(2,2,2,1);
        Texto pswContraNueva = new Texto(15, JVentana.LBL_COLOR, JVentana.BACKGROUND_COLOR);
        pnlRegistro.add(pswContraNueva, gbc);

        setGbc(0, 3, 4, 1);
        Boton btnRegistro = new Boton("Iniciar sesion", JVentana.BTN_COLOR, new Color(239, 221, 221));
        btnRegistro.delBackground();
        btnRegistro.addHoverEffect();
        btnRegistro.setForeground(JVentana.BTN_COLOR);
        pnlRegistro.add(btnRegistro, gbc);
        btnRegistro.addActionListener(e -> {
            try {
                gClientes.addCliente(new Cliente(txtNuevoUsuario.getText(), pswContraNueva.getText(), txtCorreoNuevo.getText()));
                ventana.getCards().show(ventana.getPnlTodo(), "perfil");
            } catch (UsuarioYaExistente ex) {
                JOptionPane.showMessageDialog(ventana, "Usuario ya existente");
            }
        });

        setGbc(0,4,4,1);
        Boton btnVolver = new Boton("Volver", JVentana.BTN_COLOR, new Color(239, 221, 221));
        btnVolver.delBackground();
        btnVolver.addHoverEffect();
        btnVolver.setForeground(JVentana.BTN_COLOR);
        pnlRegistro.add(btnVolver, gbc);
        btnVolver.addActionListener(e -> cards.show(this, "inicioSesion"));

        add(pnlRegistro, "registro");
    }

    public void initPnlRecuperacion(){
        JPanel pnlRecuperacion = new JPanel(new GridBagLayout());
        pnlRecuperacion.setBackground(JVentana.BACKGROUND_COLOR);

        setGbc(0,0,2,1);
        JLabel lblCorreoParaRecuperarContra = new JLabel("Correo ");
        lblCorreoParaRecuperarContra.setForeground(JVentana.LBL_COLOR);
        pnlRecuperacion.add(lblCorreoParaRecuperarContra, gbc);

        setGbc(2,0,2,1);
        Texto txtCorreoParaRecuperarContra = new Texto(15, JVentana.LBL_COLOR, JVentana.BACKGROUND_COLOR);
        pnlRecuperacion.add(txtCorreoParaRecuperarContra, gbc);

        setGbc(0,1,4,1);
        Boton btnRecuperarContra = new Boton("Recuperar", JVentana.BTN_COLOR, new Color(239, 221, 221));
        btnRecuperarContra.delBackground();
        btnRecuperarContra.addHoverEffect();
        btnRecuperarContra.setForeground(JVentana.BTN_COLOR);
        pnlRecuperacion.add(btnRecuperarContra, gbc);

        setGbc(0,2,4,1);
        Boton btnVolver = new Boton("Volver", JVentana.BTN_COLOR, new Color(239, 221, 221));
        btnVolver.delBackground();
        btnVolver.addHoverEffect();
        btnVolver.setForeground(JVentana.BTN_COLOR);
        btnVolver.addActionListener(e -> cards.show(this, "inicioSesion"));
        pnlRecuperacion.add(btnVolver, gbc);


        add(pnlRecuperacion, "recuperar");
    }


    private void setGbc(int gridX, int gridY, int gridWidth, int gridHeight){
        gbc.gridheight = gridHeight;
        gbc.gridwidth = gridWidth;
        gbc.gridx = gridX;
        gbc.gridy = gridY;
    }
}
