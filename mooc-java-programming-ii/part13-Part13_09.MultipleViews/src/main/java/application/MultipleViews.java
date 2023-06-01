package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleViews extends Application {

    public void start(Stage window) {
        Label text1 = new Label("First view!");
        Button button1 = new Button("To the second view!");
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(text1);
        borderPane.setCenter(button1);
        VBox vBox = new VBox();
        Button button2 = new Button("To the third view!");
        Label text2 = new Label("Second view!");
        vBox.getChildren().add(button2);
        vBox.getChildren().add(text2);
        GridPane gridPane = new GridPane();
        Label text3 = new Label("Third view!");
        Button button3 = new Button("To the first view!");
        // Can't add the same node (component) more than once
        gridPane.add(text3, 0, 0); // add(component, x, y) Coordinates are columns and rows 
        gridPane.add(button3, 1, 1);
        Scene first = new Scene(borderPane);
        Scene second = new Scene(vBox);
        Scene third = new Scene(gridPane);
        button1.setOnAction(event -> {
            window.setScene(second); // Change complete scene
        });
        button2.setOnAction(event -> {
            window.setScene(third);
        });
        button3.setOnAction(event -> {
            window.setScene(first);
        });
        window.setScene(first);
        window.show();
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(MultipleViews.class);
    }
}
