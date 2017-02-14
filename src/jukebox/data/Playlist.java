package jukebox.data;

import java.util.ArrayList;

/**
 * Created by Thomas on 2/14/2017.
 */
public class Playlist extends ArrayList<String> {

    private ArrayList<String> queue;
    private ArrayList<String> shuffle;

    public Playlist(){
        super();
        queue = new ArrayList<>();
        shuffle = new ArrayList<>();
    }

    @Override
    public boolean add(String s){
        // Add new song to the song list in alphabetical order
        int i = 0;
        while(i < size() && get(i).compareToIgnoreCase(s) < 0)
            i++;
        this.add(i, s);


        // Add new song to a random location in the shuffle array
        shuffle.add((int) (shuffle.size() * Math.random()), s);

        return true;
    }

}
