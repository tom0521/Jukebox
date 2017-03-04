package jukebox.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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

    private final Image DEFAULT_ALBUM_ART = new Image("music-note.png");

    @FXML private ImageView albumArt;
    @FXML private Button shuffleButton;

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
        }
        else {
            if(song.getAlbumArt() == null)
                albumArt.setImage(DEFAULT_ALBUM_ART);
            else
                albumArt.setImage(song.getAlbumArt());
        }
    }

    @FXML
    public void shuffleStateChanged(){
        jukebox.changeShuffle();
    }
}
