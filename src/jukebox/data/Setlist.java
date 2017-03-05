package jukebox.data;

import java.util.ArrayList;

/**
 * Created by Thomas on 2/28/2017.
 */
public class Setlist extends ArrayList<Song> {

    private int currentSong;

    public Setlist(){
        super();
        currentSong = -1;
    }

    /**
     * If the setlist contains the song at a value less than currentSong,
     * the method removes the song to re-add it at the end of the list and returns true
     * If it is already in the list but after currentSong the method returns false
     *
     * @param s is a song to be added
     * @return true if it was added and false if it is already in the queue
     */
    @Override
    public boolean add(Song s){
        if(contains(s)){
            remove(s);
            currentSong--;
        }
        return super.add(s);
    }

    /**
     * Increments current song and return the song
     * @return true if currentSong was incremented false if it is already equal to size
     */
    public void nextSong(){
        if(hasNextSong())
            currentSong++;
    }

    public boolean hasNextSong(){
        return currentSong + 1 < size();
    }

    public Song getCurrentSong(){
        try {
            return get(currentSong);
        }
        catch (IndexOutOfBoundsException ex){
            return null;
        }
    }

}