package com.crio.jukebox.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.crio.jukebox.entities.Playlist;

public class PlaylistRepository implements IPlaylistRepository {
    private final Map<String, Playlist> playlistMap;
    private Integer autoIncrement = 0;
    
    public PlaylistRepository(Map<String, Playlist> playlistMap, Integer autoIncrement) {
        this.playlistMap = playlistMap;
        this.autoIncrement = playlistMap.size();
    }
    public PlaylistRepository(){
        playlistMap = new HashMap<String, Playlist>();
    }
    @Override
    public Playlist  save(Playlist entity) {
        // TODO Auto-generated method stub
        if( entity.getId() == null ){
            autoIncrement++;
            Playlist q = new Playlist(Integer.toString(autoIncrement),entity.getName(),entity.getSongs(),entity.getCreator());
            playlistMap.put(q.getId(),q);
            return q;
        }
        playlistMap.put(entity.getId(),entity);
        return entity;
    }

    @Override
    public List<Playlist> findAll() {
        // TODO Auto-generated method stub
        List<Playlist> allPlaylists = playlistMap.entrySet().stream()
                                      .map(Map.Entry::getValue).collect(Collectors.toList());
        return allPlaylists;
        // return null;
    }

    @Override
    public Optional<Playlist> findById(String id) {
        // TODO Auto-generated method stub
        return Optional.ofNullable(playlistMap.get(id));
    }

    @Override
    public boolean existsById(String id) {
        // TODO Auto-generated method stub
        return playlistMap.containsKey(id);
    }

    @Override
    public void delete(Playlist entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteById(String id) {
        // TODO Auto-generated method stub
        playlistMap.remove(id);
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
