
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

    private Scanner scanner;
    private Container first;
    private Container second;

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
        this.first = new Container();
        this.second = new Container();
    }

    public void start() {
        while (true) {
            System.out.println("First: " + first);
            System.out.println("Second: " + second);
            String input = scanner.nextLine();
            if (input.equals("quit")) {
                break;
            }
            String[] parts = input.split(" ");
            String command = parts[0];
            int amount = Integer.valueOf(parts[1]);
            if (amount < 0) {
                continue;
            }
            this.processCommands(command, amount);
        }
    }

    private void processCommands(String command, int amount) {
        if (command.equals("add")) {
            this.first.add(amount);
        } else if (command.equals("move")) {
            if (amount > this.first.contains()) {
                amount = this.first.contains();
            }
            this.first.remove(amount);
            this.second.add(amount);
        } else if (command.equals("remove")) {
            this.second.remove(amount);
        }
    }
}
