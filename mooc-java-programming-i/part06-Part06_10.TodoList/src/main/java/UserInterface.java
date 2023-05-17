
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

    private TodoList list;
    private Scanner scanner;

    public UserInterface(TodoList list, Scanner scanner) {
        this.list = list;
        this.scanner = scanner;
    }

    public void start() {
        while (true) {
            System.out.println("Command:");
            String input = this.scanner.nextLine();
            if (input.equals("stop")) {
                break;
            }
            this.processCommands(input);
        }
    }

    public void processCommands(String input) {
        if (input.equals("add")) {
            this.addCommand();
        } else if (input.equals("list")) {
            this.listCommand();
        } else if (input.equals("remove")) {
            this.removeCommand();
        }
    }

    public void addCommand() {
        System.out.println("To add:");
        String task = this.scanner.nextLine();
        this.list.add(task);
    }

    public void listCommand() {
        list.print();
    }

    public void removeCommand() {
        System.out.println("Which one is removed?");
        int id = Integer.valueOf(this.scanner.nextLine());
        this.list.remove(id);
    }
}
