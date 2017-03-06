package jukebox.visualizers;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import jukebox.listeners.Visualizer;

/**
 * Created by Thomas on 3/5/2017.
 */
public class BarVisualizer extends Visualizer{

    private final int SCALAR = 2;

    @Override
    public void update(float[] magnitudes) {
        getChildren().clear();
        double barWidth = (getWidth()/2.0)/(magnitudes.length/2.0);
        for(int i = 0; i < magnitudes.length/2.0; i++){
            Rectangle bar1 = new Rectangle((getWidth()/2) - (barWidth * (i+1)), (getHeight()/2) - ((60 + magnitudes[i]) * SCALAR), barWidth, ((60 + magnitudes[i])) * SCALAR);
            bar1.setFill(Paint.valueOf("red"));
            getChildren().add(bar1);
            Rectangle bar2 = new Rectangle((getWidth()/2) + (barWidth * i), (getHeight()/2) - ((60 + magnitudes[i]) * SCALAR), barWidth, ((60 + magnitudes[i])) * SCALAR);
            bar2.setFill(Paint.valueOf("red"));
            getChildren().add(bar2);
        }
    }
}
