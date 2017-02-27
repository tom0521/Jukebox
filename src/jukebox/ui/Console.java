package jukebox.ui;

import jukebox.model.Jukebox;

import javax.swing.*;

/**
 * Created by Thomas on 2/25/2017.
 */
public class Console {
    public static void main(String[] args){
        new Console(args);
    }

    Jukebox jukebox;

    public Console(String[] drives) {
        jukebox = new Jukebox(drives);
    }
}
