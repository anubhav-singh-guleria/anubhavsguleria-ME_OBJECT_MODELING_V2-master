package com.crio.jukebox.entities;

import java.util.List;

public class Playlist extends BaseEntity {
    private final String name;
    private final List<Song> songs;
    private final User creator;
    // private Song currentSong;
    public Playlist(String name,List<Song> songs,User creator){
        this.name = name;
        this.songs = songs;
        this.creator = creator;
    }

    public Playlist(String id,String name,List<Song> songs,User creator){
        this(name, songs, creator);
        this.id = id;
    }
    public Playlist(Playlist playlist){
        this(playlist.id,playlist.name,playlist.songs,playlist.creator);
    }

    public String getName() {
        return name;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public User getCreator() {
        return creator;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Playlist other = (Playlist) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}