
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // toteuta ohjelmasi tänne        
        ArrayList<Integer> numbers = new ArrayList<>();
        while (true) {
            System.out.println("Input numbers, type \"end\" to stop.");
            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }
            int number = Integer.valueOf(input);
            numbers.add(number);
        }
        System.out.println("Print the average of the negative numbers or the positive numbers? (n/p)");
        String input = scanner.nextLine();
        if (input.equals("n")) {
            double average = numbers.stream().mapToInt(i -> i).filter(i -> i < 0).average().getAsDouble();
            System.out.println("Average of the negative numbers: " + average);
        } else if (input.equals("p")) {
            double average = numbers.stream().mapToInt(i -> i).filter(i -> i > 0).average().getAsDouble();
            System.out.println("Average of the positive numbers: " + average);
        }
    }
}
