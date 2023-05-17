
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Write your program here
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
//        int sum = 0;
//        for (int i = 0; i < numbers.size(); i++) {
//            sum = sum + numbers.get(i);
//        }
//        for (int number : numbers) {
//            sum = sum + number;
//        }
//        int i = 0;
//        while (i < numbers.size()) {
//            sum = sum + numbers.get(i);
//            i++;
//        }
//        double average = (double) sum / numbers.size();
        double average = numbers.stream().mapToInt(i -> i).average().getAsDouble();
        System.out.println("average of the numbers: " + average);
    }
}
