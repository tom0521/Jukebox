package jukebox.model;

import jukebox.data.Playlist;

import java.io.File;
import java.io.IOException;

/**
 * Created by Thomas on 2/25/2017.
 */
public class Jukebox {

    private final String[] EXT = {"mp3", "flac"};

    private Playlist playlist;

    public Jukebox(String[] drives){
        playlist = new Playlist();
        try {
            getMusic(drives);
        }
        catch (IOException ex){
            System.out.println("drives not found");
        }
    }

    public void getMusic(String[] drives) throws IOException{

        for(String drive : drives){
            File dir = new File(drive);
            searchDirectory(dir);
        }
    }

    private void searchDirectory(File dir){
        File[] files = dir.listFiles();

        for(File file : files){
            if(file.isDirectory())
                searchDirectory(file);
            else{
                for(String ext : EXT)
                    if(file.toString().endsWith(ext))
                        playlist.add(file.toPath().toString());
            }
        }
    }

    public Playlist getPlaylist(){
        return playlist;
    }
}
