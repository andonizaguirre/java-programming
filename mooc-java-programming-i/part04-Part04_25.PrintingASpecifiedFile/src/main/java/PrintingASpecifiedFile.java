
import java.nio.file.Paths;
import java.util.Scanner;

public class PrintingASpecifiedFile {

    public static void main(String[] args) {
        System.out.println("Which file should have its contents printed?");
        Scanner scannerInput = new Scanner(System.in);
        String input = scannerInput.nextLine();
        try (Scanner scannerFile = new Scanner(Paths.get(input))) {
            while (scannerFile.hasNextLine()) {
                System.out.println(scannerFile.nextLine());
            }
        } catch (Exception exception) {
            System.out.println("Reading the file failed.");
        }
    }
}
