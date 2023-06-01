package textstatistics;

import java.util.Arrays;
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
        Label letters = new Label("Letters: 0");
        Label words = new Label("Words: 0");
        Label longestWord = new Label("The longest word is: ");
        bottom.getChildren().add(letters);
        bottom.getChildren().add(words);
        bottom.getChildren().add(longestWord);
        TextArea textArea = new TextArea();
        textArea.textProperty().addListener((change, oldValue, newValue) -> {
            letters.setText("Letters: " + newValue.length());
            String[] tokens = oldValue.split(" ");
            words.setText("Words: " + tokens.length);
            String longest = tokens[0];
            for (String token : tokens) {
                if (token.length() > longest.length()) {
                    longest = token;
                }
            }
//            String longest = Arrays.stream(tokens)
//                    .sorted((s1, s2) -> s2.length() - s1.length()) // Non natural order, from longest to shortest
//                    .findFirst()
//                    .get();
            longestWord.setText("The longest word is: " + longest);
        });
        BorderPane view = new BorderPane();
        view.setCenter(textArea);
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
