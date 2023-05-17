
import java.util.ArrayList;
import java.util.Scanner;

public class PersonalInformationCollection {

    public static void main(String[] args) {
        // implement here your program that uses the PersonalInformation class
        ArrayList<PersonalInformation> infoCollection = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter first name:");
            String first = scanner.nextLine();
            if (first.isEmpty()) {
                break;
            }
            System.out.println("Enter last name:");
            String second = scanner.nextLine();
            if (second.isEmpty()) {
                break;
            }
            System.out.println("Enter identification number:");
            String id = scanner.nextLine();
            infoCollection.add(new PersonalInformation(first, second, id));
        }
        for (PersonalInformation info : infoCollection) {
            System.out.println(info.getFirstName() + " " + info.getLastName());
        }
    }
}
