package com.crio.jukebox.services;

import java.util.List;

import com.crio.jukebox.entities.Song;

public interface ISongService {
    public Song create(String songName, String genre, String albumName, String albumArtist,List<String> featuredArtists);
}
