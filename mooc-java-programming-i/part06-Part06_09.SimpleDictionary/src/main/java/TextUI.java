
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
public class TextUI {

    private Scanner scanner;
    private SimpleDictionary dict;

    public TextUI(Scanner scanner, SimpleDictionary dict) {
        this.scanner = scanner;
        this.dict = dict;
    }

    public void start() {
        while (true) {
            System.out.println("Command:");
            String input = scanner.nextLine();
            if (input.equals("end")) {
                System.out.println("Bye bye!");
                break;
            }
            if (input.equals("add")) {
                System.out.println("Word:");
                String word = scanner.nextLine();
                System.out.println("Transalation:");
                String translation = scanner.nextLine();
                this.dict.add(word, translation);
            } else if (input.equals("search")) {
                System.out.println("To be translated:");
                String word = scanner.nextLine();
                if (this.dict.translate(word) != null) {
                    System.out.println("Translation: " + this.dict.translate(word));
                } else {
                    System.out.println("Word " + word + " was not found");
                }
            } else {
                System.out.println("Unknown command:");
            }
        }
    }

//    public void start() {
//        while (true) {
//            System.out.print("Command: ");
//            String input = scanner.nextLine();
//            if (input.equals("end")) {
//                break;
//            }
//            processCommand(input);
//            System.out.println("");
//        }
//        System.out.println("Bye bye!");
//    }
//
//    public void processCommand(String command) {
//        if (command.equals("add")) {
//            add();
//        } else if (command.equals("search")) {
//            search();
//        } else {
//            System.out.println("Unknown command");
//        }
//    }
//
//    public void add() {
//        System.out.print("Word: ");
//        String word = this.scanner.nextLine();
//        System.out.print("Translation: ");
//        String translation = this.scanner.nextLine();
//        this.dictionary.add(word, translation);
//    }
//
//    public void search() {
//        System.out.print("To be translated: ");
//        String word = this.scanner.nextLine();
//        if (this.dictionary.translate(word) == null) {
//            System.out.println("Word " + word + " was not found");
//        } else {
//            System.out.println("Translation: " + this.dictionary.translate(word));
//        }
//    }
}
