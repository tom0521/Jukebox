package jukebox.data;

import java.util.ArrayList;

/**
 * Class is an ArrayList which stores the songs in alphabetical order
 * Contains two ArrayList instance variables:
 *     queue is the list of songs to be played next
 *     shuffle is the shuffled list of songs
 *
 *   ****** POSSIBLE CHANGES ********
 *   1. Remove the shuffle array list
 *      - Add a random index(in this) at index 0 in queue to track current song
 *      - Do not remove from queue
 *      - When adding randomly, if(!queue.contains(randSong))
 *      - When queue.size() == this.size(), clear the queue
 *      - No duplicates in queue
 *
 *
 * @author Thomas Sherwood
 */
public class Playlist extends ArrayList<String> {

    private ArrayList<String> _queue;
    private ArrayList<String> _shuffle;

    public Playlist(){
        super();
        _queue = new ArrayList<>();
        _shuffle = new ArrayList<>();
    }

    /**
     * adds the song to the list in alphabetical order
     *
     * @param s to add to the list
     * @return always returns true
     */
    @Override
    public boolean add(String s){
        // Add new song to the song list in alphabetical order
        int i = 0;
        while(i < size() && get(i).compareToIgnoreCase(s) < 0)
            i++;
        this.add(i, s);


        // Add new song to a random location in the shuffle array
        _shuffle.add((int) (_shuffle.size() * Math.random()), s);

        return true;
    }

    /**
     * Adds song at the given index to the queue
     *
     * ********** NOTE ***********
     *  - possibly always return true
     *
     *
     * @param index is the index of the song to be added
     * @return true if added and false otherwise
     */
    public boolean addToQueue(int index) {

        if(index < 0 || index > size())
            return false;

        _queue.add(this.get(index));
        return true;
    }

    /**
     * Removes the current song from the queue and return the next song to be played
     *
     * @return the new song to be played
     */
    public String next(){
        _queue.remove(0);
        return _queue.get(0);
    }

    /**
     * Queue getter method
     *
     * @return _queue
     */
    public ArrayList<String> getQueue(){
        return _queue;
    }

}
