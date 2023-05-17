
//import java.util.ArrayList;
import java.util.Scanner;

public class PersonalDetails {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int longest = 0;
        String name = "";
        int sum = 0;
        int count = 0;
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("")) {
                break;
            }
            String[] array = input.split(",");
            if (longest < array[0].length()) {
                longest = array[0].length();
                name = array[0];
            }
            sum = sum + Integer.valueOf(array[1]);
            count = count + 1;
        }
        System.out.println("Longest name: " + name);
        System.out.println("Average of the birth years: " + (double) sum / count);
    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        ArrayList<String> names = new ArrayList<>();
//        ArrayList<Integer> birthYears = new ArrayList<>();
//        while (true) {
//            String input = scanner.nextLine();
//            if (input.equals("")) {
//                break;
//            }
//            String[] parts = input.split(",");
//            names.add(parts[0]);
//            birthYears.add(Integer.valueOf(parts[1]));
//        }
//        String longest = names.get(0);
//        for (String name : names) {
//            if (name.length() > longest.length()) {
//                longest = name;
//            }
//        }
//        System.out.println("Longest name: " + longest);
//        int sumOfBirthYears = 0;
//        for (int year : birthYears) {
//            sumOfBirthYears = sumOfBirthYears + year;
//        }
//        System.out.println("Average of the birth years: " + 1.0 * sumOfBirthYears / birthYears.size());
//    }
}
