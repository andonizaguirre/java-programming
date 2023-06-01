package buttonandtextfield;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ButtonAndTextFieldApplication extends Application {

    public void start(Stage window) {
        Button button = new Button("Button");
        TextField textField = new TextField();
        FlowPane controlGroup = new FlowPane();
        controlGroup.getChildren().add(button);
        controlGroup.getChildren().add(textField);
        Scene scene = new Scene(controlGroup);
        window.setTitle("Button and TextField");
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(ButtonAndTextFieldApplication.class);
    }
}
