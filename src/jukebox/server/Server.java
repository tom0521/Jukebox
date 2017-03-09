package jukebox.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import jukebox.data.Song;
import jukebox.model.Jukebox;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

/**
 * Created by Thomas on 3/8/2017.
 */
public class Server {

    Jukebox jukebox;

    public Server(Jukebox jukebox) throws IOException{
        this.jukebox = jukebox;

        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/test", new Handler());
        server.setExecutor(null);
        server.start();
    }

    private class Handler implements HttpHandler {

        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
            Song song = jukebox.getPlayingSong();
            String response = "Now Playing:\n" + song.getTitle() + "\nby " + song.getArtist();
            httpExchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = httpExchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
