
import java.util.Scanner;

public class Login {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a username:");
        String user = scanner.nextLine();
        System.out.println("Enter a password:");
        String pass = scanner.nextLine();
        if (user.equals("alex") && pass.equals("sunshine")) {
            System.out.println("You have successfully logged in!");
        } else if (user.equals("emma") && pass.equals("haskell")) {
            System.out.println("You have successfully logged in!");
        } else {
            System.out.println("Incorrect username or password!");
        }
//        if ((username.equals("alex") && password.equals("sunshine")) ||
//                 (username.equals("emma") && password.equals("haskell"))) {
//            System.out.println("You have successfully logged in!");
//        } else {
//            System.out.println("Incorrect username or password!");
//        }        
    }
}
