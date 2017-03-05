package jukebox.listeners;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import jukebox.model.Jukebox;

/**
 * Created by Thomas on 3/5/2017.
 */
public class VolumeListener implements ChangeListener {

    private Jukebox jukebox;

    public VolumeListener(Jukebox jukebox){
        this.jukebox = jukebox;
    }

    @Override
    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
        jukebox.setVolume(Double.parseDouble(newValue.toString())/100);
    }
}
