package jukebox.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import jukebox.data.Song;
import jukebox.model.Jukebox;
import jukebox.ui.UserInterface;
import jukebox.ui.Window;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Thomas on 2/28/2017.
 */
public class WindowController implements Initializable, UserInterface{

    @FXML private ImageView albumArt;
    @FXML private CheckBox shuffleButton;
    @FXML private Label titleLabel, artistLabel, albumLabel;
    @FXML private Slider volumeSlider;

    private Jukebox jukebox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        jukebox = new Jukebox(this, Window.directories);
    }

    @Override
    public void update() {
        Song song = jukebox.getSetlist().getCurrentSong();

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

    @FXML
    public void volumeChanged(){
        System.out.println(volumeSlider.getValue());
    }
}
