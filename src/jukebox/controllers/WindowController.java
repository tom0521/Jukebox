package jukebox.controllers;

import javafx.fxml.Initializable;
import jukebox.model.Jukebox;
import jukebox.ui.UserInterface;
import jukebox.ui.Window;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Thomas on 2/28/2017.
 */
public class WindowController implements Initializable, UserInterface{

    private Jukebox jukebox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        jukebox = new Jukebox(this, Window.directories);
    }

    @Override
    public void update() {

    }
}
