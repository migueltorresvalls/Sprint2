package test;

import main.java.domain.Pelicula;
import main.java.domain.Playlist;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlaylistTest {

    private Playlist playlist;
    private Playlist playlistCorrecta;

    @org.junit.Before
    public void setUp() throws Exception{
        playlist = new Playlist(1, "Miguel");
        playlistCorrecta = new Playlist(1, "Miguel");
    }

    @Test
    public void getNombre() {
        String nombre = playlist.getNombre();
        assertEquals("Miguel", nombre);
    }

    @Test
    public void getId_playlist() {
        int id_playlist = playlist.getId_playlist();
        assertEquals(1, id_playlist);
    }

    @Test
    public void testEquals() {
        boolean equals = playlist.equals(playlistCorrecta);
        assertEquals(true, equals);
    }
}