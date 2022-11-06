package test;

import main.java.domain.Cliente;
import main.java.domain.Pelicula;
import org.junit.Test;

import static org.junit.Assert.*;

public class PeliculaTest {

    private Pelicula pelicula;

    @org.junit.Before
    public void setUp() throws Exception{
        pelicula = new Pelicula(1, "Avatar", 2005, "url.prueba.com");
    }

    @Test
    public void getNombre() {
        String nombre = pelicula.getNombre();
        assertEquals("Avatar", nombre);
    }

    @Test
    public void getUrl() {
        String url = pelicula.getUrl();
        assertEquals("url.prueba.com", url);
    }

    @Test
    public void getYear() {
        int year = pelicula.getYear();
        assertEquals(2005, year);
    }
}