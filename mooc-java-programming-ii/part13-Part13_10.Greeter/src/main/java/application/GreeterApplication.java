package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GreeterApplication extends Application {

    public void start(Stage window) {
        Label label = new Label("Enter your name and start.");
        TextField textField = new TextField();
        Button button = new Button("Start");
        VBox layout = new VBox();
        layout.getChildren().addAll(label, textField, button);
        layout.setPrefSize(300, 180);
        layout.setAlignment(Pos.CENTER);
        Scene login = new Scene(layout);
        Label welcomeText = new Label("");
        FlowPane layout2 = new FlowPane();
        layout2.getChildren().add(welcomeText);
        Scene welcome = new Scene(layout2);
        button.setOnAction(event -> {
            welcomeText.setText("Welcome " + textField.getText() + "!");
            window.setScene(welcome);
        });
        window.setScene(login);
        window.show();
    }

    public static void main(String[] args) {
        System.out.println("Hellow world! :3");
        launch(GreeterApplication.class);
    }
}
