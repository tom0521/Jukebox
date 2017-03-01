package jukebox.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.List;

/**
 * Created by Thomas on 2/28/2017.
 */
public class Window extends Application {

    public static void main(String[] args){
        launch(args);
    }

    public static String[] directories;

    @Override
    public void start(Stage primaryStage) throws Exception {
        List<String> args = getParameters().getRaw();
        directories = new String[args.size()];
        for(int i = 0; i < args.size(); i++){
            directories[i] = args.get(i);
        }

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/jukebox/fxml/JukeboxView.fxml"));
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        }
        catch(Exception ex){
            System.out.println("'JukeboxView.fxml' not found");
        }
    }
}
