
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

    private Container container1;
    private Container container2;
    private Scanner scanner;

    public UserInterface(Scanner scanner) {
        this.container1 = new Container();
        this.container2 = new Container();
        this.scanner = scanner;
    }

    public void processCommands(String command, int amount) {
        if (command.equals("add")) {
            this.container1.add(amount);
        } else if (command.equals("move")) {
            if (amount > container1.contains()) {
                amount = container1.contains();
            }
            container1.remove(amount);
            container2.add(amount);
        } else if (command.equals("remove")) {
            this.container2.remove(amount);
        }
    }

    public void start() {
        while (true) {
            System.out.println("First: " + this.container1.contains() + "/100");
            System.out.println("Second: " + this.container2.contains() + "/100");
            String input = scanner.nextLine();
            if (input.equals("quit")) {
                break;
            }
            String[] parts = input.split(" ");
            String command = parts[0];
            int amount = Integer.valueOf(parts[1]);
            this.processCommands(command, amount);
        }
    }
}
