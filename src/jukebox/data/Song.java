package jukebox.data;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * This class is an instance of a Song object
 * the song object takes the pathname of the song and
 * gets and stores the information about it (i.e. Title, Album Art, etc.)
 *
 *
 * @author Thomas Sherwood
 */
public class Song {

    private Metadata metadata;

    public Song(File file){
        try {
            metadata = new Metadata(file);

        }
        catch (IOException ex){
            System.out.println("Unsuccessful Tag Retrival");
        }
    }

    public Image getAlbumArt() {
        return metadata.getAlbumArt();
    }

    public long getLength() {
        return metadata.getLength();
    }

    public String getAlbum() {
        return metadata.getAlbum();
    }

    public String getArtist() {
        return metadata.getArtist();
    }

    public String getYear() {
        return metadata.getYear();
    }

    public String getTitle() {
        return metadata.getTitle();
    }

    public int getTrack() {
        return metadata.getTrack();
    }

}

