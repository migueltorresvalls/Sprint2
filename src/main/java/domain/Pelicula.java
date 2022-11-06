package main.java.domain;

//Revisar y hacer la herencia con series
public class Pelicula {

    private int id_p;
    private String nombre;
    private int year;
    private String url;

    public Pelicula(int id_p, String nombre, int year, String url){
        this.id_p = id_p;
        this.nombre = nombre;
        this.year = year;
        this.url = url;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUrl(){
        return url;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString(){
        return "---PELICULA---\nId: " + id_p +
                "\nNombre: " + nombre +
                "\naño: " + year +
                "\nurl: " + url;
    }
}
