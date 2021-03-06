package jukebox.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import jukebox.data.Song;
import jukebox.listeners.Visualizer;
import jukebox.data.Jukebox;
import jukebox.ui.UserInterface;
import jukebox.ui.Window;
import jukebox.visualizers.BarVisualizer;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Thomas on 2/28/2017.
 */
public class WindowController implements Initializable, UserInterface{

    @FXML private StackPane stackPane;
    @FXML private ImageView albumArt;
    @FXML private CheckBox shuffleButton;
    @FXML private Label titleLabel, artistLabel, albumLabel;
    @FXML private Slider volumeSlider;

    private Jukebox jukebox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Visualizer visualizer = new BarVisualizer();
        stackPane.getChildren().add(0, visualizer);
        jukebox = new Jukebox(this, visualizer, Window.directories);
        volumeSlider.valueProperty().addListener(new VolumeListener());
    }

    @Override
    public void update() {
        Song song = jukebox.getPlayingSong();

        if(song == null){
            albumArt.setImage(null);
            titleLabel.setText("");
            artistLabel.setText("");
            albumLabel.setText("");
        }
        else {
            if(song.getAlbumArt() == null)
                albumArt.setImage(new Image("music-note.png"));
            else
                albumArt.setImage(song.getAlbumArt());

            titleLabel.setText(song.getTitle());
            artistLabel.setText(song.getArtist());
            albumLabel.setText(song.getAlbum());
        }
    }

    @FXML
    public void shuffleChanged(){
        jukebox.setShuffle(shuffleButton.isSelected());
    }

    private class VolumeListener implements ChangeListener {
        @Override
        public void changed(ObservableValue observable, Object oldValue, Object newValue) {
            jukebox.setVolume(Double.parseDouble(newValue.toString())/100);
        }
    }
}
