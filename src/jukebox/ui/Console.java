package jukebox.ui;

import jukebox.data.Song;
import jukebox.model.Jukebox;

/**
 * Created by Thomas on 2/25/2017.
 */
public class Console implements UserInterface {
    public static void main(String[] args){
        new Console(args);
    }

    private Jukebox jukebox;

    public Console(String[] drives) {
        jukebox = new Jukebox(this, drives);
        for (Song s : jukebox.getPlaylist()){
            System.out.println(s.toString() + ": " + s.getAlbumArt());
        }
    }

    @Override
    public void update() {

    }
}
