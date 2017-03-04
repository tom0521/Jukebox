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

    public Playlist(){
        super();
    }

    /**
     *  TO DO: FIX THE SORTING TO IGNORE 'THE'
     *
     */

    @Override
    public boolean add(Song s){
        // Add new song to the song list in order by artist then album then track in that order
        int i = 0;
        while(i < size() && (get(i).getArtist().compareToIgnoreCase(s.getArtist()) < 0 ||
                (get(i).getArtist().compareToIgnoreCase(s.getArtist()) == 0 && get(i).getAlbum().compareToIgnoreCase(s.getAlbum()) < 0) ||
                (get(i).getAlbum().compareToIgnoreCase(s.getAlbum()) == 0 && get(i).getTrack() < s.getTrack())))
            i++;
        this.add(i, s);

        return true;
    }

}
