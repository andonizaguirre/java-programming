package title;

import javafx.application.Application;
import javafx.stage.Stage;

public class UserTitle extends Application {

    public void start(Stage window) {
        Parameters parameters = getParameters();
        window.setTitle(parameters.getNamed().get("title"));
        window.show();
    }
}
