package jukebox.data;

import java.awt.*;
import java.io.IOException;

/**
 * This class is an instance of a Song object
 * the song object takes the pathname of the song and
 * gets and stores the information about it (i.e. Title, Album Art, etc.)
 *
 * ******* REWORK THE METADATA RETRIEVAL PROCESS ********
 *
 * @author Thomas Sherwood
 */
public class Song {

    private String _pathname, _title, _artist, _album,  _year, _track;
    private Image _albumArt;
    private long _length;

    public Song(String pathname){
        _pathname = pathname;
    }

    public Image getAlbumArt() {
        return _albumArt;
    }

    public long getLength() {
        return _length;
    }

    public String getAlbum() {
        return _album;
    }

    public String getArtist() {
        return _artist;
    }

    public String getYear() {
        return _year;
    }

    public String getTitle() {
        return _title;
    }

    public String getTrack() {
        return _track;
    }

}
