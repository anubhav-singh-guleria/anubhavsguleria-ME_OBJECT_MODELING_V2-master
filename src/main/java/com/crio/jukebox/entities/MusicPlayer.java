package com.crio.jukebox.entities;

public class MusicPlayer {
    private Playlist currentPlaylist;
    private User currentUser;
    private Song currentSong;
    private Integer id;


    public MusicPlayer(Playlist currentPlaylist, User currentUser, Song currentSong){
        this.id = 0;
        this.currentPlaylist = currentPlaylist;
        this.currentUser = currentUser;
        this.currentSong = currentSong;
    }


    public MusicPlayer() {
    }


    public Playlist getCurrentPlaylist() {
        return currentPlaylist;
    }

    
    public void setCurrentPlaylist(Playlist currentPlaylist) {
        this.currentPlaylist = currentPlaylist;
    }
    public User getCurrentUser() {
        return currentUser;
    }
    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
    public Song getCurrentSong() {
        return currentSong;
    }
    public void setCurrentSong(Song currentSong) {
        this.currentSong = currentSong;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
}
