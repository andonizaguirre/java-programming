
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
    private Points points;

    public UserInterface(Scanner scanner) {
        this.scanner = new Scanner(System.in);
        this.points = new Points();
    }

    public void start() {
        System.out.println("Enter points total, -1 stops:");
        while (true) {
            int point = Integer.valueOf(this.scanner.nextLine());
            if (point == -1) {
                break;
            }
            if (0 <= point && point <= 100) {
                this.points.getPointsList().add(point);
            }
        }
        System.out.println("Point average (all): " + this.points.average());
        double avgPassing = this.points.averageOfPassingGrade(50);
        if (avgPassing >= 50) {
            System.out.println("Point average (passing): " + avgPassing);
        } else {
            System.out.println("Point average (passing): -");
        }
        System.out.println("Pass percentage: " + this.points.passPercentage(50));
        System.out.println("Grade distribution:");
        this.printStars(this.points.pointsConversion());
    }

    public void printStars(int[] grades) {
        for (int i = 5; i >= 0; i--) {
            String stars = "";
            for (int grade : grades) {
                if (grade == i) {
                    stars = stars + "*";
                }
            }
            System.out.println(i + ": " + stars);
        }
    }
}
