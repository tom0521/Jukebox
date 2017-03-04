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
    private boolean shuffle;

    public Jukebox(UserInterface ui, String[] directories){
        userInterface = ui;

        playlist = new Playlist();
        setlist = new Setlist();

        getMusic(directories);
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
        if(shuffle && (mediaPlayer == null || mediaPlayer.getStatus() == MediaPlayer.Status.DISPOSED)) {
            setlist.add(playlist.get((int) (Math.random() * (playlist.size() - 1))));
            initMediaPlayer(setlist.next().getMedia());
        }
        userInterface.update();
    }

    public Playlist getPlaylist(){
        return playlist;
    }

    public Setlist getSetlist(){
        return setlist;
    }

    public void changeShuffle(){
        shuffle = !shuffle;
        update();
    }

    private void initMediaPlayer(Media media){
        mediaPlayer = new MediaPlayer(media);

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
                if(setlist.next() != null){
                    initMediaPlayer(setlist.getCurrentSong().getMedia());
                }
                else
                    update();
            }
        });
    }
}
