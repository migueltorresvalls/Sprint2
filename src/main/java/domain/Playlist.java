package main.java.domain;

public class Playlist {

    private String nombre;
    private int id_playlist;

    public Playlist(int id_playlist, String nombre){
        this.nombre= nombre;
        this.id_playlist=id_playlist;
    }
    public String getNombre(){
        return nombre;}

    public int getId_playlist(){
        return id_playlist;}

    @Override
    public boolean equals(Object o){
        if (o instanceof Playlist){
            Playlist c = (Playlist) o;
            if (c.getNombre().equals(nombre)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString(){
        return "---PLAYLIST---\nNombre: " + nombre +
                ", Id: " + id_playlist;
    }

}
