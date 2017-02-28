package jukebox.model;

import jukebox.data.Playlist;
import jukebox.data.Song;
import jukebox.ui.UserInterface;

import java.io.File;

/**
 * Created by Thomas on 2/25/2017.
 */
public class Jukebox {

    private final String[] EXT = {"mp3", "flac", "m4a"};

    private Playlist playlist;
    private UserInterface userInterface;

    public Jukebox(UserInterface userInterface, String[] directories){
        this.userInterface = userInterface;

        playlist = new Playlist();

        getMusic(directories);
    }

    public void getMusic(String[] directories) {

        for(String dir : directories){
            searchDirectory(new File(dir));
        }
    }

    private void searchDirectory(File dir){
        File[] files = dir.listFiles();

        if(files != null)
            for (File file : files)
                if (file.isDirectory())
                    searchDirectory(file);
                else
                    for (String ext : EXT)
                        if (file.toString().endsWith(ext))
                            playlist.add(new Song(file));
    }

    public Playlist getPlaylist(){
        return playlist;
    }
}
