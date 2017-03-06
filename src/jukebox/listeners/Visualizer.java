package jukebox.listeners;

import javafx.scene.layout.Pane;
import javafx.scene.media.AudioSpectrumListener;

/**
 * Created by Thomas on 3/5/2017.
 */
public abstract class Visualizer extends Pane implements AudioSpectrumListener {

    public abstract void update(float[] magnitudes);

    @Override
    public void spectrumDataUpdate(double timestamp, double duration, float[] magnitudes, float[] phases) {
        update(magnitudes);
    }
}
