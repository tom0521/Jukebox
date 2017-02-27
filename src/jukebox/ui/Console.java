package jukebox.ui;

import jukebox.model.Jukebox;

/**
 * Created by Thomas on 2/25/2017.
 */
public class Console implements UserInterface {
    public static void main(String[] args){
        new Console(args);
    }

    Jukebox jukebox;

    public Console(String[] drives) {
        jukebox = new Jukebox(this, drives);
    }

    @Override
    public void update() {

    }
}
