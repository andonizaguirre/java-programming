package collage;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CollageApplication extends Application {

    @Override
    public void start(Stage stage) {
        Image sourceImage = new Image("file:monalisa.png");
        PixelReader imageReader = sourceImage.getPixelReader();
        int width = (int) sourceImage.getWidth();
        int height = (int) sourceImage.getHeight();
        WritableImage targetImage = new WritableImage(width, height);
        PixelWriter imageWriter = targetImage.getPixelWriter();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Color color = imageReader.getColor(j, i); // x, y
                double red = color.getRed();
                double green = color.getGreen();
                double blue = color.getBlue();
                double opacity = color.getOpacity();
                Color newColor = new Color(red, green, blue, opacity);
                imageWriter.setColor(j, i, newColor);
            }
        }
        // Smaller copy of the image
        for (int i = 0; i < height / 2; i++) {
            for (int j = 0; j < width / 2; j++) {
                Color color = imageReader.getColor(j * 2, i * 2);
                imageWriter.setColor(j, i, color);
            }
        }
        // Copy the smaller image to the other corners
        imageReader = targetImage.getPixelReader();
        for (int i = 0; i < height / 2; i++) {
            for (int j = 0; j < width / 2; j++) {
                Color color = imageReader.getColor(j, i); // this takes the color of the copy
                imageWriter.setColor(j + width / 2, i, color);
                imageWriter.setColor(j, i + height / 2, color);
                imageWriter.setColor(j + width / 2, i + height / 2, color);
            }
        }
        // All images, entire width and height (pixel by pixel)
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Color color = imageReader.getColor(j, i);
                double r = 1 - color.getRed();
                double g = 1 - color.getGreen();
                double b = 1 - color.getBlue();
                Color negative = new Color(r, g, b, color.getOpacity());
                imageWriter.setColor(j, i, negative);
            }
        }
        ImageView image = new ImageView(targetImage);
        Pane pane = new Pane();
        pane.getChildren().add(image);
        stage.setScene(new Scene(pane));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args); // Equivalent to launch(CollageApplication.class)
    }
}
