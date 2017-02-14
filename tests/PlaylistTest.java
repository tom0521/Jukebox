import jukebox.data.Playlist;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Thomas on 2/14/2017.
 */
public class PlaylistTest {

    @Test
    public void playlistSortTest(){
        ArrayList<String> sorted = new ArrayList<>();
        sorted.add("apple"); sorted.add("Banana"); sorted.add("GraPE");

        Playlist playlist = new Playlist();
        playlist.add("Banana"); playlist.add("apple"); playlist.add("GraPE");

        assertEquals(sorted, playlist);
    }
}
