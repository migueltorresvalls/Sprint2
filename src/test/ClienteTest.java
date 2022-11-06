package test;

import main.java.domain.Cliente;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClienteTest {

    private Cliente cliente;
    private Cliente clienteCorrecto;

    @org.junit.Before
    public void setUp() throws Exception{
        cliente = new Cliente("miguel", "Miguel", "miguel@gmail.com");
        clienteCorrecto = new Cliente("miguel", "Miguel", "miguel@gmail.com");
    }

    @Test
    public void getNombre() {
        String nombre = cliente.getNombre();
        assertEquals("miguel", nombre);
    }

    @Test
    public void getContra() {
        String contra = cliente.getContra();
        assertEquals("Miguel", contra);
    }

    @Test
    public void getCorreo() {
        String correo = cliente.getCorreo();
        assertEquals("miguel@gmail.com", correo);
    }

    @Test
    public void testEquals() {
        Boolean isEqual = cliente.equals(clienteCorrecto);
        assertEquals(true, isEqual);
    }
}