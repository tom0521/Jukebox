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
 *      - Add a random index(in this)
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

    public Playlist(){
        super();
        _queue = new ArrayList<>();
    }

    @Override
    public boolean add(String s){
        // Add new song to the song list in alphabetical order
        int i = 0;
        while(i < size() && get(i).compareToIgnoreCase(s) < 0)
            i++;
        this.add(i, s);

        return true;
    }

    public boolean addToQueue(int index) {

        if(index < 0 || index > size())
            return false;

        _queue.add(this.get(index));
        return true;
    }

    public String next(){
        _queue.remove(0);
        return _queue.get(0);
    }

    public ArrayList<String> getQueue(){
        return _queue;
    }

}
