package jukebox.data;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;

import javax.imageio.ImageIO;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

/**
 * Created by Thomas on 2/27/2017.
 */
public class Metadata {

    private long length;
    private Tag tag;

    public Metadata(File file) throws IOException{
        try {
            AudioFile audioFile = AudioFileIO.read(file);
            length = audioFile.getAudioHeader().getTrackLength();
            tag = audioFile.getTag();
        }
        catch (Exception ex){
            System.out.println("Cannot get tags from " + file.toString());
        }
    }

    public long getLength(){
        return length;
    }

    public String getTitle(){
        return tag.getFirst(FieldKey.TITLE);
    }

    public String getArtist() {
        return tag.getFirst(FieldKey.ARTIST);
    }

    public String getAlbum() {
        return tag.getFirst(FieldKey.ALBUM);
    }

    public String getYear() {
        return tag.getFirst(FieldKey.YEAR);
    }

    public int getTrack(){
        return Integer.parseInt(tag.getFirst(FieldKey.TRACK));
    }

    public Image getAlbumArt() {
        if(tag.getFirstArtwork() != null) {
            byte[] data = tag.getFirstArtwork().getBinaryData();

            try {
                return SwingFXUtils.toFXImage(ImageIO.read(new ByteArrayInputStream(data)), null);
            } catch (IOException e) {
            }

        }
        return null;
    }
}
