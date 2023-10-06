package com.crio.jukebox.commands;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.crio.jukebox.entities.Song;
import com.crio.jukebox.repositories.ISongRepository;

public class LoadDataCommand implements ICommand{
    private final ISongRepository songRepository;
    public LoadDataCommand(ISongRepository songRepository) {
        this.songRepository = songRepository;
    }
    @Override
    public void execute(List<String> tokens) throws FileNotFoundException {
        // TODO Auto-generated method stub
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(tokens.get(1)));
            String songData = reader.readLine();
            while(songData!=null){
                Song song = convert(songData);
                songData = reader.readLine();
                songRepository.save(song);
            }
            reader.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Songs Loaded successfully");
    }
    public Song convert(String line){
        List<String> tokens = Arrays.asList(line.split(","));
        List<String> featuredArtists = Arrays.asList(tokens.get(4).split("#"));
        Song song = new Song(tokens.get(0), tokens.get(1), tokens.get(2), tokens.get(3), featuredArtists);
        return song;
    }
}
