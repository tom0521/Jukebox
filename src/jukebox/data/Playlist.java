package jukebox.data;

import java.util.ArrayList;

/**
 * Class is an ArrayList which stores the songs in alphabetical order
 * Contains two ArrayList instance variables:
 *     queue is the list of songs to be played next
 *     shuffle is the shuffled list of songs
 *
 *   ****** POSSIBLE CHANGES ********
 *      - Do not remove from queue
 *      - When adding randomly, if(!queue.contains(randSong))
 *      - When queue.size() == this.size(), clear the queue
 *      - No duplicates in queue
 *
 *
 * @author Thomas Sherwood
 */
public class Playlist extends ArrayList<Song> {

    private ArrayList<Song> queue;

    public Playlist(){
        super();
        queue = new ArrayList<>();
    }

    /**
     *  TO DO: FIX THE SORTING TO IGNORE 'THE' AND GET TRACKS IN CORRECT ORDER
     *
     * @param s
     * @return
     */

    @Override
    public boolean add(Song s){
        // Add new song to the song list in alphabetical order
        int i = 0;
        while(i < size() && get(i).toString().compareToIgnoreCase(s.toString()) < 0)
            i++;
        this.add(i, s);

        return true;
    }

    public boolean addToQueue(int index) {

        if(index < 0 || index > size())
            return false;

        queue.add(this.get(index));
        return true;
    }

    /**
     *  NEEDS TO BE RETURN THE NEXT LONG
     *
     * @return
     */

    public Song next(){
        return queue.get(0);
    }

    public ArrayList<Song> getQueue(){
        return queue;
    }

}
