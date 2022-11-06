package main.java.controler;


import main.java.dao.ConexionBD;
import main.java.domain.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GestorBD {

    private ArrayList<Cliente> clientes;
    private ArrayList<Pelicula> peliculas;
    private ArrayList<Playlist> playlists;



    private ConexionBD conexionBd;

    public GestorBD(ConexionBD conexionBd){
        this.conexionBd = conexionBd;
        clientes = conexionBd.fetchClientes();
        peliculas = conexionBd.fetchPeliculas();
        playlists = conexionBd.fetchPlaylist();
    }

    public ConexionBD getBdUsuarios(){
        return conexionBd;
    }

    public ArrayList<Cliente> getClientes(){
        return clientes;
    }

    public ArrayList<Pelicula> getPeliculas(){
        return peliculas;
    }

    public ArrayList<Playlist> getPlaylists(){
        return playlists;
    }
    public Cliente getCliente(String usuario){
        for(Cliente cliente : clientes){
            if (cliente.getNombre().equals(usuario)){
                return cliente;
            }
        }
        return null;
    }

    public Playlist getPlaylist(String nombrePlaylist){
        for(Playlist playlist: playlists){
            if (playlist.getNombre().equals(nombrePlaylist)){
                return playlist;
            }
        }
        return null;
    }

    public ArrayList<Pelicula> buscarPelicula(String nombre){
        ArrayList<Pelicula> peliculasEncontradas = new ArrayList<>();

        peliculas.forEach(pelicula -> {
            //String primeraPalabra = pelicula.getNombre().toLowerCase().split(" ")[0];
            if (pelicula.getNombre().toLowerCase().contains(nombre.toLowerCase())){
                peliculasEncontradas.add(pelicula);
            }
        });

        return peliculasEncontradas;
    }

    public ArrayList<Cliente> buscarClientes(String nombre){
        ArrayList<Cliente> clientesEncontrados = new ArrayList<>();

        clientes.forEach(c -> {
            if (c.getNombre().toLowerCase().contains(nombre.toLowerCase())){
                clientesEncontrados.add(c);

            }
        });

        return clientesEncontrados;
    }

    public ArrayList<String> getNombresPeliculas(){
        ArrayList<String> nombresPeliculas = new ArrayList<>();

        peliculas.forEach(p -> nombresPeliculas.add(p.getNombre()));
        return nombresPeliculas;
    }

    public ArrayList<String> getNombresUsuario(){
        ArrayList<String> nombresUsuarios = new ArrayList<>();

        clientes.forEach(c -> nombresUsuarios.add(c.getNombre()));
        return nombresUsuarios;
    }
    public ArrayList<String> getNombresPlaylist(){
        ArrayList<String> nombresPlaylist= new ArrayList<>();

        playlists.forEach(c -> nombresPlaylist.add(c.getNombre()));
        return nombresPlaylist;
    }

    public void addCliente(Cliente cliente) throws UsuarioYaExistente {
        if (!getNombresUsuario().contains(cliente.getNombre())){
            conexionBd.addCliente(cliente);
            clientes.add(cliente);
        }else{
            throw new UsuarioYaExistente();
        }
    }
    public void addPlaylist(Playlist playlist) throws PlaylistYaExistente{
        if(!getNombresPlaylist().contains(playlist.getNombre())) {
            conexionBd.addPlaylist(playlist);
            playlists.add(playlist);
        }else{
            throw new PlaylistYaExistente();
        }
    }

}
