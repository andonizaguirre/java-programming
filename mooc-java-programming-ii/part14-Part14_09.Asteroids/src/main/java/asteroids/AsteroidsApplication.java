package asteroids;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AsteroidsApplication extends Application {

    Map<KeyCode, Boolean> pressedKeys = new HashMap<>();
    List<Projectile> projectiles = new ArrayList<>();
    public static int WIDTH = 300;
    public static int HEIGHT = 200;

    public void start(Stage window) throws Exception {
        Pane pane = new Pane();
        pane.setPrefSize(WIDTH, HEIGHT);
        Text text = new Text(10, 20, "Points: 0");
        AtomicInteger points = new AtomicInteger();
        // Create ship
        Ship ship = new Ship(WIDTH / 2, HEIGHT / 2); // Initial coordinates
        // Create asteroids
        List<Asteroid> asteroids = new ArrayList<>();
        // Amount of asteroids 
        for (int i = 0; i < 5; i++) {
            Random rnd = new Random();
            Asteroid asteroid = new Asteroid(rnd.nextInt(WIDTH / 3), rnd.nextInt(HEIGHT));
            asteroids.add(asteroid);
        }
        pane.getChildren().add(text);
        pane.getChildren().add(ship.getCharacter());
        asteroids.forEach(asteroid -> pane.getChildren().add(asteroid.getCharacter()));
        Scene view = new Scene(pane);
        // Event listeners
        view.setOnKeyPressed(event -> {
            this.pressedKeys.put(event.getCode(), Boolean.TRUE);
        });
        view.setOnKeyReleased(event -> {
            this.pressedKeys.put(event.getCode(), Boolean.FALSE);
        });
        new AnimationTimer() {
            public void handle(long now) {
                // Random chance to spawn an asteroid over time
                if (Math.random() < 0.005) {
                    Asteroid asteroid = new Asteroid(WIDTH, HEIGHT);
                    if (!asteroid.collide(ship)) { // If the game is still going (ship didnt collide)
                        asteroids.add(asteroid);
                        pane.getChildren().add(asteroid.getCharacter());
                    }
                }
                // Handle keys being pressed
                if (pressedKeys.getOrDefault(KeyCode.LEFT, false)) { // In case the key has not yet been pressed (not in the map), default value is false
                    ship.turnLeft();
                }
                if (pressedKeys.getOrDefault(KeyCode.RIGHT, false)) {
                    ship.turnRight();
                }
                if (pressedKeys.getOrDefault(KeyCode.UP, false)) {
                    ship.accelerate();
                }
                if (pressedKeys.getOrDefault(KeyCode.SPACE, false) && projectiles.size() < 3) {
                    Projectile projectile = new Projectile((int) ship.getCharacter().getTranslateX(), (int) ship.getCharacter().getTranslateY()); // Create projectile on ship location
                    projectile.getCharacter().setRotate(ship.getCharacter().getRotate()); // Set projectile direction same as ship's
                    projectiles.add(projectile);
                    projectile.accelerate();
                    projectile.setMovement(projectile.getMovement().normalize().multiply(3));
                    pane.getChildren().add(projectile.getCharacter());
                }
                // Move characters
                ship.move();
                asteroids.forEach(asteroid -> asteroid.move());
                projectiles.forEach(projectile -> projectile.move());
                // Handle projectile and asteroid disappearance on collision
                projectiles.forEach(projectile -> {
                    asteroids.forEach(asteroid -> {
                        if (projectile.collide(asteroid)) {
                            projectile.setAlive(false);
                            asteroid.setAlive(false);
                        }
                    });
                    //handles the points
                    if (!projectile.isAlive()) {
                        text.setText("Points: " + points.addAndGet(1000));
                    }
                });
                projectiles.stream()
                        .filter(projectile -> !projectile.isAlive())
                        .forEach(projectile -> pane.getChildren().remove(projectile.getCharacter()));
                projectiles.removeAll(projectiles.stream()
                        .filter(projectile -> !projectile.isAlive())
                        .collect(Collectors.toList()));
                asteroids.stream()
                        .filter(asteroid -> !asteroid.isAlive())
                        .forEach(asteroid -> pane.getChildren().remove(asteroid.getCharacter()));
                asteroids.removeAll(asteroids.stream()
                        .filter(asteroid -> !asteroid.isAlive())
                        .collect(Collectors.toList()));
                // Check collision between ship and asteroids, end game
                asteroids.forEach(asteroid -> {
                    if (ship.collide(asteroid)) {
                        stop();
                    }
                });
            }
        }.start();
        asteroids.forEach(asteroid -> asteroid.turnRight());
        asteroids.forEach(asteroid -> asteroid.accelerate());
        /*
        view.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.LEFT) {
//                ship.setRotate(-30);
                ship.setRotate(ship.getRotate() - 5);
            }
            if (event.getCode() == KeyCode.RIGHT) {
//                ship.setRotate(30);
                ship.setRotate(ship.getRotate() + 5);
            }
        });
         */
        window.setTitle("Asteroids!");
        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static int partsCompleted() {
        // State how many parts you have completed using the return value of this method
        return 4;
    }
}
