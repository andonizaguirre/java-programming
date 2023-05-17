
import java.nio.file.Paths;
import java.util.Scanner;

public class RecordsFromAFile {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name of the file?");
        String fileName = scanner.nextLine();
        try (Scanner fileReader = new Scanner(Paths.get(fileName))) {
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] lineSplitted = line.split(",");
                System.out.println(lineSplitted[0] + ", age: " + lineSplitted[1] + " years");
//                String name = lineSplitted[0];
//                int age = Integer.valueOf(lineSplitted[1]);// 
//                if (age == 1) {
//                    System.out.println(name + ", age: " + age + " year");
//                } else {
//                    System.out.println(name + ", age: " + age + " years");
//                }
            }
        } catch (Exception e) {
            System.out.println("Reading the file failed.");
        }
    }
}
