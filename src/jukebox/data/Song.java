package jukebox.data;

import java.awt.*;
import java.io.IOException;

import com.mpatric.mp3agic.*;

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
        setMetadata("", "", "", "", "", null);
    }

    public boolean getMetadata(){
        try {
            Mp3File song = new Mp3File(_pathname);
            _length = song.getLengthInSeconds();

            if(song.hasId3v1Tag()){
                ID3v1 tag = song.getId3v1Tag();
                setMetadata(tag.getTitle(), tag.getArtist(), tag.getAlbum(), tag.getYear(), tag.getTrack(), null);
            }
            else if(song.hasId3v2Tag()){
                ID3v2 tag = song.getId3v2Tag();
                //get album art
                setMetadata(tag.getTitle(), tag.getArtist(), tag.getAlbum(), tag.getYear(), tag.getTrack(), null);
            }
        }
        catch (IOException ex){}
        catch (UnsupportedTagException ex){}
        catch (InvalidDataException ex){}

        return true;
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

    private void setMetadata(String title, String artist, String album, String year, String track, Image albumArt){
        _title = title;
        _artist = artist;
        _album = album;
        _year = year;
        _albumArt = albumArt;
        _track = track;
    }

}
