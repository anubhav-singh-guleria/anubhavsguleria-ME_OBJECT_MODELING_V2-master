package com.crio.jukebox.services;

import java.util.List;


import com.crio.jukebox.entities.Playlist;
import com.crio.jukebox.entities.Song;
import com.crio.jukebox.entities.User;

public interface IPlaylistService {
    public Playlist create(String name,List<Song> songs,User creator);
    public void deletePlaylist(String id,User user);
    public void addSongs(String id,User user ,List<Song> list);
    public void deleteSongs(String id,User user,List<Song> list);
}
