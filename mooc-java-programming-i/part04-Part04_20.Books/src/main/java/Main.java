
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // implement here the program that allows the user to enter 
        // book information and to examine them
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> arrayList = new ArrayList<>();
        while (true) {
            System.out.println("Title:");
            String title = scanner.nextLine();
            if (title.isEmpty()) {
                break;
            }
            System.out.println("Pages:");
            int pages = Integer.valueOf(scanner.nextLine());
            System.out.println("Publication year:");
            int pubYear = Integer.valueOf(scanner.nextLine());
            Book book = new Book(title, pages, pubYear);
            arrayList.add(book);
        }
        System.out.println("What information will be printed?");
        String info = scanner.nextLine();
        if (info.equals("everything")) {
            for (Book book : arrayList) {
                System.out.println(book);
            }
        } else if (info.equals("name")) {
            for (Book book : arrayList) {
                System.out.println(book.getName());
            }
        }
    }
}
