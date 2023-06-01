/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import logic.Dictionary;

/**
 *
 * @author andoni
 */
public class PracticeView {

    private Dictionary dictionary;
    private String word;

    public PracticeView(Dictionary dictionary) {
        this.dictionary = dictionary;
        this.word = dictionary.getRandomWord();
        System.out.println(word);
    }

    public Parent getView() {
        Label wordInstruction = new Label("Translate the word '" + this.word + "'");
        TextField translationField = new TextField();
        Button checkButton = new Button("Check");
        Label feedback = new Label("");
        GridPane layout = new GridPane();
        layout.add(wordInstruction, 0, 0);
        layout.add(translationField, 0, 1);
        layout.add(checkButton, 0, 2);
        layout.add(feedback, 0, 3);
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        checkButton.setOnMouseClicked((event) -> {
            String translation = translationField.getText();
            if (this.dictionary.get(this.word).equals(translation)) {
                feedback.setText("Correct!");
            } else {
                feedback.setText("Incorrect! The translation of the word '" + this.word + "' is '" + this.dictionary.get(this.word) + "'.");
                return;
            }
            this.word = this.dictionary.getRandomWord();           
            wordInstruction.setText("Translate the word '" + this.word + "'");
            translationField.clear();
        });
        return layout;
    }
}
