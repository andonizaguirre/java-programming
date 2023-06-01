package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import logic.Dictionary;
import userInterface.InputView;
import userInterface.PracticeView;

// END SOLUTION
public class VocabularyPracticeApplication extends Application {

    public void start(Stage window) {
        Button enterButton = new Button("Enter new words");
        Button practiceButton = new Button("Practice");
        HBox menu = new HBox();
        menu.getChildren().addAll(enterButton, practiceButton);
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setSpacing(10);
        Dictionary dictionary = new Dictionary();
        InputView inputView = new InputView(dictionary);
        PracticeView practiceView = new PracticeView(dictionary);
        BorderPane layout = new BorderPane();
        layout.setTop(menu);
        layout.setCenter(inputView.getView());
        Scene view = new Scene(layout, 400, 300);
        enterButton.setOnAction((event) -> layout.setCenter(inputView.getView()));
        practiceButton.setOnAction((event) -> layout.setCenter(practiceView.getView()));
        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(VocabularyPracticeApplication.class);
    }
}
