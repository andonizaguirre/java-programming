
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LiteracyComparison {

    public static void main(String[] args) {
        try {
            Files.lines(Paths.get("literacy.csv"))
                    .map(row -> row.split(","))
                    .filter(parts -> parts.length >= 6)
                    .sorted((p1, p2) -> {
                        return p1[5].compareTo(p2[5]);
                    })
                    .forEach(parts -> System.out.println(parts[3] + " (" + parts[4] + ")" + ", " + parts[2].trim().split(" ")[0] + ", " + parts[5]));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    // Could also create a class object to store the values and instantiate objects with map() and add them to a list with forEach()
}
