package main.java.dao;


import main.java.domain.Cliente;
import main.java.domain.Pelicula;
import main.java.domain.Playlist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConexionBD {

    private Connection con;

    public ConexionBD(Connection con){
        this.con = con;
    }

    public void addCliente(Cliente cliente) {
        try {
            con.prepareStatement("INSERT INTO usuarios VALUES ('" + cliente.getNombre() + "', '" + cliente.getContra() + "', '" + cliente.getCorreo() + "')").executeQuery();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public void addPlaylist(Playlist playlist){
        try{
            con.prepareStatement("INSERT INTO playlist VALUES ('" + playlist.getId_playlist() +"', '" +playlist.getNombre()+ "')").executeQuery();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }


    public ArrayList<Cliente> fetchClientes(){
        ArrayList<Cliente> clientes = new ArrayList<>();
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM usuarios");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                clientes.add(new Cliente(rs.getString(1), rs.getString(2), rs.getString(3)));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return clientes;
    }

    //Revisar y hacer la herencia con series
    public ArrayList<Pelicula> fetchPeliculas(){
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM peliculas");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                peliculas.add(new Pelicula(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(5)));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return peliculas;
    }
    public ArrayList<Playlist> fetchPlaylist(){
        ArrayList<Playlist> playlists = new ArrayList<>();
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM playlist");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                playlists.add(new Playlist(rs.getInt(1), rs.getString(2)));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return playlists;
    }

}
