package com.crio.jukebox.services;

import java.util.List;
import java.util.Optional;


import com.crio.jukebox.entities.Playlist;
import com.crio.jukebox.entities.Song;
import com.crio.jukebox.entities.User;
import com.crio.jukebox.exceptions.PlaylistNotFoundEception;
import com.crio.jukebox.exceptions.SongNotFoundException;
import com.crio.jukebox.repositories.IPlaylistRepository;
import com.crio.jukebox.repositories.ISongRepository;
import com.crio.jukebox.repositories.IUserRepository;

public class PlaylistService implements IPlaylistService{
    

    private final IPlaylistRepository playlistRepository;
    private final IUserRepository userRepository;
    private final ISongRepository songRepository;
    

    public PlaylistService(IPlaylistRepository playlistRepository, IUserRepository userRepository,
            ISongRepository songRepository) {
        this.playlistRepository = playlistRepository;
        this.userRepository = userRepository;
        this.songRepository = songRepository;
    }


    @Override
    public Playlist create(String name, List<Song> songs, User creator) throws SongNotFoundException{
        Playlist playlist = new Playlist(name, songs, creator);
        creator.getPlaylists().add(playlist);
        return playlistRepository.save(playlist);
    }


    @Override
    public void deletePlaylist(String id, User user) throws PlaylistNotFoundEception{
        // TODO Auto-generated method stub
        Optional<Playlist> optioanlPlaylist = playlistRepository.findById(id);
        Playlist playlist;
        if(optioanlPlaylist.isPresent()){
            playlist = optioanlPlaylist.get();
        }else throw(new PlaylistNotFoundEception("Playlist Not Found"));
        user.getPlaylists().remove(playlist);
        playlistRepository.deleteById(id);
    }


    @Override
    public void addSongs(String id, User user, List<Song> list) throws SongNotFoundException{
        // TODO Auto-generated method stub
        Playlist playlist = playlistRepository.findById(id).get();
        for(Song song: list){
            if(playlist.getSongs().contains(song))continue;
            else playlist.getSongs().add(song);
        }
    }


    @Override
    public void deleteSongs(String id, User user, List<Song> list) throws SongNotFoundException{
        // TODO Auto-generated method stub
        Playlist playlist = playlistRepository.findById(id).get();
        for(Song song:list){
            if(playlist.getSongs().contains(song)) playlist.getSongs().remove(song);
            else throw(new SongNotFoundException("Song not found"));
        }
    }

    
    
}
