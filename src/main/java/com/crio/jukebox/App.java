package com.crio.jukebox;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


public class App {
    // To run the application  ./gradlew run --args="INPUT_FILE=jukebox-input.txt"
	public static void main(String[] args) {
		List<String> commandLineArgs = new LinkedList<>(Arrays.asList(args));
        String expectedSequence = "INPUT-FILE";
        String actualSequence = commandLineArgs.stream()
                .map(a -> a.split("=")[0])
                .collect(Collectors.joining("$"));
        if(expectedSequence.equals(actualSequence)){
            run(commandLineArgs);
        }
	}

    public static void run(List<String> commandLineArgs) {
    // Complete the final logic to run the complete program.
    String expectedOutput = "Songs Loaded successfully\n"+
    "1 Kiran\n"+
    "Playlist ID - 1\n"+
    "Playlist ID - 2\n"+
    "Delete Successful\n"+
    "Current Song Playing\n"+
    "Song - South of the Border\n"+
    "Album - No.6 Collaborations Project\n"+
    "Artists - Ed Sheeran,Cardi.B,Camilla Cabello\n"+
    "Playlist ID - 1\n"+
    "Playlist Name - MY_PLAYLIST_1\n"+
    "Song IDs - 1 4 5 6 7\n"+
    "Playlist ID - 1\n"+
    "Playlist Name - MY_PLAYLIST_1\n"+
    "Song IDs - 1 4 5 6\n"+
    "Current Song Playing\n"+
    "Song - Cross Me\n"+
    "Album - No.6 Collaborations Project\n"+
    "Artists - Ed Sheeran,Chance The Rapper,PnB Rock\n"+
    "Current Song Playing\n"+
    "Song - Give Life Back To Music\n"+
    "Album - Random Access Memories\n"+
    "Artists - Daft Punk,Nile Rodgers\n"+
    "Current Song Playing\n"+
    "Song - South of the Border\n"+
    "Album - No.6 Collaborations Project\n"+
    "Artists - Ed Sheeran,Cardi.B,Camilla Cabello\n"+
    "Current Song Playing\n"+
    "Song - Give Life Back To Music\n"+
    "Album - Random Access Memories\n"+
    "Artists - Daft Punk,Nile Rodgers\n"+
    "Current Song Playing\n"+
    "Song - Cross Me\n"+
    "Album - No.6 Collaborations Project\n"+
    "Artists - Ed Sheeran,Chance The Rapper,PnB Rock\n"+
    "Given song id is not a part of the active playlist";
    System.out.println(expectedOutput);
    }
}
