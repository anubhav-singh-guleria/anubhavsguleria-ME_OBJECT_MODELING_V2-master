package com.crio.jukebox.entities;

import java.util.ArrayList;
import java.util.List;

public class User extends BaseEntity {
    private final String name;
    private final List<Playlist> playlists;
    
    public User(String name, List<Playlist> playlists){
        this.name = name;
        this.playlists = playlists;
    }

    public User(String id, String name, List<Playlist> playlists){
        this(name,playlists);
        this.id = id;
    }
    
    
    public User(String name) {
        this.name = name;
        this.playlists = new ArrayList<Playlist>();
    }

    public String getName() {
        return name;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    @Override
    public String toString() {
        return this.id+" "+name;
    }
    
}