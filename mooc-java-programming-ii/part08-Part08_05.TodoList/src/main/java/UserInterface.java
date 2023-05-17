
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
    private TodoList tasks;

    public UserInterface(TodoList tasks, Scanner scanner) {
        this.tasks = tasks;
        this.scanner = scanner;
    }

    public void start() {
        while (true) {
            System.out.println("Command: ");
            String command = scanner.nextLine();
            if (command.equals("stop")) {
                break;
            }
            this.processCommands(command);
        }
    }

    private void processCommands(String command) {
        if (command.equals("add")) {
            System.out.println("To add:");
            String task = scanner.nextLine();
            this.tasks.add(task);
        } else if (command.equals("list")) {
            this.tasks.print();
        } else if (command.equals("remove")) {
            System.out.println("Which one is removed?");
            int id = Integer.valueOf(scanner.nextLine());
            this.tasks.remove(id);
        }
    }
}
