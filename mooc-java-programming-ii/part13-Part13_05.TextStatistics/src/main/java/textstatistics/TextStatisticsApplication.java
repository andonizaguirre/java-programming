package textstatistics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextStatisticsApplication extends Application {

    public void start(Stage window) {
        HBox bottom = new HBox();
        bottom.setSpacing(10);
        bottom.getChildren().add(new Label("Letters: 0"));
        bottom.getChildren().add(new Label("Words: 0"));
        bottom.getChildren().add(new Label("The longest word is:"));
        BorderPane view = new BorderPane();
        view.setCenter(new TextArea());
        view.setBottom(bottom);
        Scene scene = new Scene(view);
        window.setTitle("Text Statistics");
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(TextStatisticsApplication.class);
    }
}
