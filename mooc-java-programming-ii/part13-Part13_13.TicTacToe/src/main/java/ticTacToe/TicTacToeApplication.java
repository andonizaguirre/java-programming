/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticTacToe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logic.TicTacToe;

/**
 *
 * @author andoni
 */
public class TicTacToeApplication extends Application {

    public void start(Stage window) {
        TicTacToe ticTacToe = new TicTacToe();
        Font monoSpaced = Font.font("Monospaced", 40);
        Label gameStatus = new Label("Turn: " + ticTacToe.getTurn());
        gameStatus.setFont(monoSpaced);
        BorderPane layout = new BorderPane();
        layout.setTop(gameStatus);
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));
        // Map the tictactoe matrix to the gridpane (inverted positions)
        String[][] ticTacToeMatrix = ticTacToe.getTicTacToe();
        for (int i = 0; i < ticTacToeMatrix.length; i++) {
            for (int j = 0; j < ticTacToeMatrix[i].length; j++) { 
                Button button = new Button(ticTacToeMatrix[j][i]); // Not relevenat since it is only setting a blank String " "
                button.setFont(monoSpaced);
                grid.add(button, j, i); // x, y Columns and rows (inverted in GridPane)
                int ri = i;
                int rj = j;
                button.setOnAction(event -> {
                    ticTacToe.place(rj, ri);
                    button.setText(ticTacToeMatrix[rj][ri]); // [i][j] == [y][x] Rows and columns
                    gameStatus.setText("Turn: " + ticTacToe.getTurn());
                    if (ticTacToe.ended()) {
                        gameStatus.setText("The end!");
                    }
                });
            }
        }
        layout.setCenter(grid);
        Scene view = new Scene(layout);
        window.setScene(view);
        window.setTitle("Tic-tac-toe");
        window.show();
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(TicTacToeApplication.class);
    }
}
