package title;

import java.util.Scanner;
import javafx.application.Application;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Provide a title for the GUI");
        String input = scanner.nextLine();
        Application.launch(UserTitle.class, // Static method call from another class requires the specific class
                "--title=" + input);
    }
}
