package notifier;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NotifierApplication extends Application {

    public void start(Stage window) {
        VBox verticalControlGroup = new VBox();
        TextField textField = new TextField();
        Button button = new Button("Update");
        Label label = new Label();
        /*        
        public class CustomEventHandler implements EventHandler<ActionEvent> {
            
            private Label label;
            private TextField textField;
        
            public CustomEventHandler(Label label, TextField textField) {
                this.label = label;
                this.textField = textField;
            }
        
            @Override
            public void handle(ActionEvent event) { // Handle method invoked when specific event for which this handler is registered happens
                this.label.setText(this.textField.getText());
            }
        } 
        button.setOnAction(new CustomEventHandler(label, textField)); // Pass an object that implements EventHandler<ActionEvent> interface
         */
//        button.setOnAction(new EventHandler<ActionEvent>() { // Functional Interface (one method), allows to instantiate interface and pass the specific implementation of the method
//            @Override
//            public void handle(ActionEvent event) {
//                label.setText(textField.getText());
//            }
//        });
        button.setOnAction(event -> { // Lambda expression
            label.setText(textField.getText());
        });
        verticalControlGroup.getChildren().addAll(textField, button, label);
        Scene scene = new Scene(verticalControlGroup);
        window.setTitle("Notifier");
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(NotifierApplication.class);
    }
}
