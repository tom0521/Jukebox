import jukebox.data.Playlist;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Thomas on 2/14/2017.
 */
public class PlaylistTest {

    private Playlist playlist;

    @Before
    public void initializeTests(){
        playlist = new Playlist();
        playlist.add("Banana"); playlist.add("apple"); playlist.add("GraPE");
    }

    @Test
    public void playlistSortTest(){
        ArrayList<String> sorted = new ArrayList<>();
        sorted.add("apple"); sorted.add("Banana"); sorted.add("GraPE");

        assertEquals(sorted, playlist);
    }

    @Test
    public void addToQueueTest(){

        assertTrue(playlist.addToQueue(0));
        assertFalse(playlist.addToQueue(4));

        playlist.addToQueue(1);
        playlist.addToQueue(2);

        assertEquals(playlist, playlist.getQueue());
    }

    @Test
    public void nextTest(){
        playlist.addToQueue(0);
        playlist.addToQueue(1);

        assertEquals("Banana", playlist.next());
    }
}
