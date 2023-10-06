package com.crio.jukebox.services;

import java.util.List;

import com.crio.jukebox.entities.Song;
import com.crio.jukebox.repositories.ISongRepository;

public class SongService implements ISongService{
    private final ISongRepository songRepository;
    
    public SongService(ISongRepository songRepository) {
        this.songRepository = songRepository;
    }
    
    @Override
    public Song create(String songName, String genre, String albumName, String albumArtist,
            List<String> featuredArtists) {
        // TODO Auto-generated method stub
        Song song = new Song(songName,genre,albumName,albumArtist,featuredArtists);        
        return songRepository.save(song); 
    }
    
}
