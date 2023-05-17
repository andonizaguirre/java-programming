
import java.util.ArrayList;
import java.util.Scanner;

public class OnlyTheseNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        while (true) {
            int number = Integer.valueOf(scanner.nextLine());
            if (number == -1) {
                break;
            }
            numbers.add(number);
        }
        System.out.println("From where?");
        int firstIndex = Integer.valueOf(scanner.nextLine());
        System.out.println("To where?");
        int lastIndex = Integer.valueOf(scanner.nextLine());
        for (int i = firstIndex; i <= lastIndex; i++) {
            System.out.println(numbers.get(i));
        }        
//        while (firstIndex <= lastIndex) {
//            int number = numbers.get(firstIndex);
//            System.out.println(number);
//            firstIndex = firstIndex + 1;
//        }        
    }
}
