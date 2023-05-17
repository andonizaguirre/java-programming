
import java.util.HashMap;

public class Program {

    public static void main(String[] args) {
        // Test your program here!
    }

    public static void printValues(HashMap<String, Book> hashmap) {
        for (Book book : hashmap.values()) {
            System.out.println(book);
        }
    }

    public static void printValueIfNameContains(HashMap<String, Book> hashmap, String text) {
        for (Book book : hashmap.values()) {
            if (book.getName().contains(text)) {
                System.out.println(book);
            }
        }
        // This would only work in case the key is exactly the same as the book name
//        for (String key : hashmap.keySet()) {
//            if (key.contains(text)) {
//                System.out.println(hashmap.get(key));
//            }
//        }
    }
}
