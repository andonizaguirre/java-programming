
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author andoni
 */
public class UserInterface {

    private JokeManager jokeManager;
    private Scanner scanner;

    public UserInterface(JokeManager jokeM, Scanner sc) {
        this.jokeManager = jokeM;
        this.scanner = sc;
    }

    public void start() {
        while (true) {
            System.out.println("Commands:");
            System.out.println(" 1 - add a joke");
            System.out.println(" 2 - draw a joke");
            System.out.println(" 3 - list jokes");
            System.out.println(" X - stop");
            String input = this.scanner.nextLine();
            if (input.equals("X")) {
                break;
            }
            this.processCommands(input);
        }
    }

    public void processCommands(String input) {
        if (input.equals("1")) {
            System.out.println("Write the joke to be added:");
            String joke = this.scanner.nextLine();
            this.jokeManager.addJoke(joke);
        } else if (input.equals("2")) {
            System.out.println("Drawing a joke.");
            System.out.println(this.jokeManager.drawJoke());
        } else if (input.equals("3")) {
            System.out.println("Printing the jokes.");
            this.jokeManager.printJokes();
        }
    }
}
