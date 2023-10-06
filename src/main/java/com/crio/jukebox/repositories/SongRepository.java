package com.crio.jukebox.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.crio.jukebox.entities.Song;

public class SongRepository implements ISongRepository{

    private final Map<String, Song> songMap;
    private Integer autoIncrement = 0;
    
    public SongRepository(Map<String, Song> songMap, Integer autoIncrement) {
        this.songMap = songMap;
        this.autoIncrement = songMap.size();
    }
    public SongRepository(){
        this.songMap = new HashMap<String, Song>();
    }

    @Override
    public Song save(Song entity) {
        // TODO Auto-generated method stub
        if( entity.getId() == null ){
            autoIncrement++;
            Song q = new Song(Integer.toString(autoIncrement),entity.getSongName(),entity.getGenre(),entity.getAlbumName(),entity.getAlbumArtist(),entity.getFeaturedArtists());
            songMap.put(q.getId(),q);
            return q;
        }
        songMap.put(entity.getId(),entity);
        return entity;
        // return null;
    }

    @Override
    public List<Song> findAll() {
        // TODO Auto-generated method stub
        List<Song> allSongs = songMap.entrySet().stream()
                                      .map(Map.Entry::getValue).collect(Collectors.toList());
        return allSongs;
    }

    @Override
    public Optional<Song> findById(String id) {
        // TODO Auto-generated method stub
        return Optional.ofNullable(songMap.get(id));
    }

    @Override
    public boolean existsById(String id) {
        // TODO Auto-generated method stub
        return songMap.containsKey(id);
    }

    @Override
    public void delete(Song entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteById(String id) {
        // TODO Auto-generated method stub
        songMap.remove(id);
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
