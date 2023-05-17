
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // implement here your program that uses the TelevisionProgram class
        ArrayList<TelevisionProgram> programs = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Name:");
            String name = scanner.nextLine();
            if (name.isEmpty()) {
                break;
            }
            System.out.println("Duration:");
            int duration = Integer.valueOf(scanner.nextLine());
            TelevisionProgram tvProgram = new TelevisionProgram(name, duration);
            programs.add(tvProgram);
//            programs.add(new TelevisionProgram(name, duration));
        }
        System.out.println("Program maximum duration?");
        int maxDuration = Integer.valueOf(scanner.nextLine());
        for (TelevisionProgram tvProgram : programs) {
            if (tvProgram.getDuration() <= maxDuration) {
                System.out.println(tvProgram);
            }
        }
    }
}
