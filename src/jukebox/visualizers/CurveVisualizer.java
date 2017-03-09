package jukebox.visualizers;

import javafx.scene.shape.Path;
import jukebox.listeners.Visualizer;

/**
 * Created by Thomas on 3/9/2017.
 */
public class CurveVisualizer extends Visualizer{
    @Override
    public void update(float[] magnitudes) {

    }

    private class Curve extends Path {
        private double frequency; // Add speed that goes with bpm?
        private int magnitude;

        public Curve(){

        }

    }
}
