package hurraa;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class HurraaSovellus extends Application {

    @Override
    public void start(Stage window) throws Exception {
        BorderPane layout = new BorderPane();
        Button button = new Button("Hurraa!");
        layout.setCenter(button);
        AudioClip audio = new AudioClip("file:Applause-Yannick_Lemieux.wav");
        button.setOnAction(event -> audio.play());
        Scene view = new Scene(layout, 600, 400);
        window.setScene(view);
        window.setTitle("Audio clip");
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
