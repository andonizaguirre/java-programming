package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JokeApplication extends Application {

    public void start(Stage window) {
        Button jokeButton = new Button("Joke");
        Button answerButton = new Button("Answer");
        Button explanationButton = new Button("Explanation");
        HBox menu = new HBox();
        menu.getChildren().addAll(jokeButton, answerButton, explanationButton);
        StackPane contentLayout1 = this.createView("What do you call a bear with no teeth?");
        StackPane contentLayout2 = this.createView("A gummy bear.");
        StackPane contentLayout3 = this.createView("Pun that references the famous candy");
        BorderPane layout = new BorderPane();
        layout.setTop(menu);
        layout.setCenter(contentLayout1);
        // Same scene, change part of it using different layouts, it is also possible to directly just change one component
        jokeButton.setOnAction(event -> layout.setCenter(contentLayout1));
        answerButton.setOnAction(event -> layout.setCenter(contentLayout2));
        explanationButton.setOnAction(event -> layout.setCenter(contentLayout3));
        Scene view = new Scene(layout);
        window.setScene(view);
        window.setTitle("Jokes");
        window.show();
    }

    private StackPane createView(String text) {
        StackPane contentLayout = new StackPane();
        contentLayout.setPrefSize(300, 180);
        contentLayout.getChildren().add(new Label(text));
        contentLayout.setAlignment(Pos.CENTER);
        return contentLayout;
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(JokeApplication.class);
    }
}
