package com.crio.jukebox.exceptions;

public class PlaylistNotFoundEception extends RuntimeException{

    public PlaylistNotFoundEception() {
        super();
    }

    public PlaylistNotFoundEception(String message) {
        super(message);
    }
    
    
}
