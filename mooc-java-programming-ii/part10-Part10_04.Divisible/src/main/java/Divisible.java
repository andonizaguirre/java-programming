
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Divisible {

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(2);
        numbers.add(-17);
        numbers.add(-5);
        numbers.add(7);
        ArrayList<Integer> divisible = divisible(numbers);
        divisible.stream().forEach(luku -> System.out.println(luku));
    }

//    public static boolean divisibleFilter(int n) {
//        return n % 2 == 0 || n % 3 == 0 || n % 5 == 0;
//    }

    public static ArrayList<Integer> divisible(ArrayList<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0 || n % 3 == 0 || n % 5 == 0)
//                .filter((n) -> {
//                    return n % 2 == 0 || n % 3 == 0 || n % 5 == 0;
//                })
//                .filter(n -> Divisible.divisibleFilter(n)) // In this case there is no need to specify the Class.
//                .filter(Divisible::divisibleFilter)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
