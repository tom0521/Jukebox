
import static org.junit.Assert.*;

import jukebox.data.Song;
import org.junit.*;

import java.io.File;

/**
 * Created by Thomas on 2/26/2017.
 */
public class SongTest {

    Song song;

    @Before
    public void createSong(){
        song = new Song(new File("E:\\_Extra\\01 Don't Sing (feat. Benny Sings).m4a"));
    }

    @Test
    public void checkMetadata(){
        assertEquals("Don't Sing (feat. Benny Sings)", song.getTitle());
        assertEquals("Data", song.getArtist());
        System.out.println(song.getAlbum());
        System.out.println(song.getLength());
        System.out.println(song.getTrack());
        System.out.println(song.getYear());
    }
}
