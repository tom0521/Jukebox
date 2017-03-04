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
        if(indexOf(s) <= currentSong){
            if(contains(s)) {
                remove(s);
                currentSong--;
            }

            return super.add(s);
        }

        return false;
    }

    /**
     * If there is a next song in the setlist this method increments the currentSong and return the song
     * else it returns null
     * @return next song or null
     */
    public Song next(){
        if(currentSong < size()) {
            currentSong++;
            return get(currentSong);
        }

        return null;
    }

    public Song getCurrentSong(){
        if(currentSong < 0 || currentSong >= size())
            return null;

        return get(currentSong);
    }

}