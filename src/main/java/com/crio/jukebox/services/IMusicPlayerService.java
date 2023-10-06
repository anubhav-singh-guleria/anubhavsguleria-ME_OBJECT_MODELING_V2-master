package com.crio.jukebox.services;

import com.crio.jukebox.entities.Buttons;
// import com.crio.jukebox.entities.Modify;
import com.crio.jukebox.entities.Playlist;
import com.crio.jukebox.entities.Song;
import com.crio.jukebox.entities.User;

public interface IMusicPlayerService {
    public void playPlaylist(User user, Playlist playlist);
    public void playSong(User user, Song song);
    public void playSong(User user, Buttons buttons);   
}
