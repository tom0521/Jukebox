package jukebox.model;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import jukebox.data.Playlist;
import jukebox.data.Setlist;
import jukebox.data.Song;
import jukebox.ui.UserInterface;

import java.io.File;

/**
 * Created by Thomas on 2/25/2017.
 */
public class Jukebox {

    private final String[] EXTENSIONS = {"mp3", "m4a"};

    private MediaPlayer mediaPlayer;
    private Playlist playlist;
    private Setlist setlist;
    private UserInterface userInterface;
    private double volume;
    private boolean shuffle;

    public Jukebox(UserInterface ui, String[] directories){
        userInterface = ui;

        playlist = new Playlist();
        setlist = new Setlist();

        getMusic(directories);

        volume = 0.75;
    }

    public void getMusic(String[] directories) {

        for(String dir : directories){
            searchDirectory(new File(dir));
        }
    }

    private void searchDirectory(File dir){
        File[] files = dir.listFiles();

        if(files != null)
            for (File file : files)
                if (file.isDirectory())
                    searchDirectory(file);
                else
                    for (String ext : EXTENSIONS)
                        if (file.toString().endsWith(ext))
                            playlist.add(new Song(file));
    }

    public void update(){
        if( mediaPlayer == null || mediaPlayer.getStatus() == MediaPlayer.Status.DISPOSED) {
            if (setlist.hasNextSong()) {
                setlist.nextSong();
                initMediaPlayer(setlist.getCurrentSong().getMedia());
            } else if (shuffle) {
                setlist.add(playlist.get((int) (Math.random() * (playlist.size() - 1))));
                setlist.nextSong();
                initMediaPlayer(setlist.getCurrentSong().getMedia());
            }
        }
        userInterface.update();
    }

    public Playlist getPlaylist(){
        return playlist;
    }

    public Setlist getSetlist(){
        return setlist;
    }

    public void setShuffle(boolean shuffle){
        this.shuffle = shuffle;
        update();
    }

    private void initMediaPlayer(Media media){
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setVolume(volume);

        mediaPlayer.setOnReady(new Runnable() {
            @Override
            public void run() {
                mediaPlayer.play();
            }
        });

        mediaPlayer.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                mediaPlayer.dispose();
                update();
            }
        });
    }

    public Song getPlayingSong(){
        if(mediaPlayer == null || mediaPlayer.getStatus() == MediaPlayer.Status.DISPOSED)
            return null;

        return setlist.getCurrentSong();
    }

    public void setVolume(double value){
        if(mediaPlayer != null) {
            mediaPlayer.setVolume(value);
            volume = value;
        }
    }
}
