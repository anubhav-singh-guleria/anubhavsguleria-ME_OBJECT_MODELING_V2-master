package com.crio.jukebox.services;

import com.crio.jukebox.entities.Buttons;
// import com.crio.jukebox.entities.Modify;
import com.crio.jukebox.entities.MusicPlayer;
import com.crio.jukebox.entities.Playlist;
import com.crio.jukebox.entities.Song;
import com.crio.jukebox.entities.User;
import com.crio.jukebox.exceptions.SongNotFoundException;

public class MusicPlayerService implements IMusicPlayerService{
    private MusicPlayer musicPlayer;

    @Override
    public void playPlaylist(User user, Playlist playlist) {
        // TODO Auto-generated method stub
        this.musicPlayer = new MusicPlayer(playlist, user, playlist.getSongs().get(0));
        
    }

    @Override
    public void playSong(User user, Song song) throws SongNotFoundException{
        // TODO Auto-generated method stub
        musicPlayer.setCurrentSong(song);
        Integer newId = musicPlayer.getCurrentPlaylist().getSongs().indexOf(song);
        if(newId==-1)throw new SongNotFoundException("Song not found!");
        musicPlayer.setId(newId);
    }

    @Override
    public void playSong(User user, Buttons buttons) {
        // TODO Auto-generated method stub
        Integer sizeOfSongList = musicPlayer.getCurrentPlaylist().getSongs().size();
        if(buttons == Buttons.BACK){
            musicPlayer.setId((musicPlayer.getId()-1)%sizeOfSongList);
            musicPlayer.setCurrentSong(musicPlayer.getCurrentPlaylist().getSongs().get(musicPlayer.getId()));
        }else{

        }
    }
    
}
