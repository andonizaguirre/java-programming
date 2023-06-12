package smiley;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SmileyApplication extends Application {

    public void start(Stage window) {
        Canvas paintingCanvas = new Canvas(480, 480);
        GraphicsContext painter = paintingCanvas.getGraphicsContext2D();
        painter.setFill(Color.WHITE);
        painter.clearRect(0, 0, 480, 480); // Paint all canvas white
        painter.setFill(Color.BLACK);
        painter.fillRect(120, 50, 50, 50); // Left eye
        painter.fillRect(480 - 120 - 50, 50, 50, 50); // Right eye, calculated from opposite side
        painter.fillRect(70, 250, 50, 50); // Top left mouth
        painter.fillRect(480 - 70 - 50, 250, 50, 50); // Top right mouth, calculated from opposite side
        painter.fillRect(120, 300, 240, 50); // End = x + width = 120 + 240 = 360 = top right mouth 
        BorderPane layout = new BorderPane();
        layout.setCenter(paintingCanvas);
        Scene view = new Scene(layout);
        window.setScene(view);
        window.setTitle("Smiley");
        window.show();
    }

    public static void main(String[] args) {
        launch(SmileyApplication.class);
    }
}
