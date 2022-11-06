package main.java.domain;

public class PlaylistYaExistente extends Exception{

    public PlaylistYaExistente(){
        super("Esta playlist ya existe.");
    }
}
