package borderpane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BorderPaneApplication extends Application {

    public void start(Stage window) {
        BorderPane controlGroup = new BorderPane();
        controlGroup.setTop(new Label("NORTH"));
        controlGroup.setRight(new Label("EAST"));
        controlGroup.setBottom(new Label("SOUTH"));
        Scene scene = new Scene(controlGroup);
        window.setTitle("BorderPane");
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(BorderPaneApplication.class);
    }
}
