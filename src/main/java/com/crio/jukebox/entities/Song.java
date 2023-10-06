package com.crio.jukebox.entities;

import java.util.List;

public class Song extends BaseEntity {
    private final String songName;
    private final String genre;
    private final String albumName;
    private final String albumArtist;
    private List<String> featuredArtists;

    public Song(String songName, String genre, String albumName, String albumArtist,List<String> featuredArtists){
        this.songName = songName;
        this.genre = genre;
        this.albumName = albumName;
        this.albumArtist = albumArtist;
        this.featuredArtists = featuredArtists;
    }

    public Song(String id,String songName, String genre, String albumName, String albumArtist,List<String> featuredArtists){
        this(songName,genre,albumName,albumArtist,featuredArtists);
        this.id = id;
    }

    public Song(Song song){
        this(song.id,song.songName,song.genre,song.albumName,song.albumArtist,song.featuredArtists);
    }
    public String getSongName() {
        return songName;
    }

    public String getGenre() {
        return genre;
    }

    public String getAlbumName() {
        return albumName;
    }

    public String getAlbumArtist() {
        return albumArtist;
    }

    public List<String> getFeaturedArtists() {
        return featuredArtists;
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
        Song other = (Song) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    // @Override
    // public String toString(){
        
    // }
}