package buttonandlabel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ButtonAndLabelApplication extends Application {

    public void start(Stage window) {
        Label label = new Label("Label");
        Button button = new Button("Button");
        FlowPane controlGroup = new FlowPane();
        controlGroup.getChildren().add(label);
        controlGroup.getChildren().add(button);
        Scene scene = new Scene(controlGroup);
        window.setTitle("Button and Label");
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(ButtonAndLabelApplication.class);
    }
}
