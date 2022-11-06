package main.java.domain;

public class UsuarioYaExistente extends Exception{

    public UsuarioYaExistente(){
        super("Usuario ya existente");
    }
}
