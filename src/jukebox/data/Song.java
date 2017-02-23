package jukebox.data;

import java.awt.*;

/**
 * This class is an instance of a Song object
 * the song object takes the pathname of the song and
 * gets and stores the information about it (i.e. Title, Album Art, etc.)
 *
 * @author Thomas Sherwood
 */
public class Song {

    /**
     * Strings to hold the metadata
     */
    private String _pathname, _title, _artist, _album,  year;

    /**
     * Image to hold the album artwork
     */
    private Image _albumArt;

    /**
     * integer to hold the song length
     */
    private int _length;


    /**
     * Constructor initializes all the instance variables
     *
     * @param pathname location of the mp3 file
     */
    public Song(String pathname){
        _pathname = pathname;
    }


}
