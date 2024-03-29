
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LimitedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> inputs = new ArrayList<Integer>();
        while (true) {
            int number = Integer.valueOf(scanner.nextLine());
            if (number < 0) {
                break;
            }
            inputs.add(number);
        }
        inputs.stream().filter(n -> 1 <= n && n <= 5).forEach(n -> System.out.println(n));
    }
}
