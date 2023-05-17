
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class SportStatistics {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("File:");
        String file = scan.nextLine();
        System.out.println("Team:");
        String team = scan.nextLine();
        ArrayList<Game> games = readFile(file);
        ArrayList<Game> gamesOfTeam = new ArrayList<>();
        for (Game game : games) {
            if (team.equals(game.getHomeTeam()) || team.equals(game.getVisitorTeam())) {
                gamesOfTeam.add(game);
            }
        }
        System.out.println("Games: " + gamesOfTeam.size());
        int wins = 0;
        for (Game game : gamesOfTeam) {
            if (game.gameWinner(team)) {
                wins++;
            }
        }
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + (gamesOfTeam.size() - wins));
//        Scanner scan = new Scanner(System.in);
//        System.out.println("File:");
//        String file = scan.nextLine();
//        System.out.println("Team:");
//        String team = scan.nextLine();
//        int count = 0;
//        int wins = 0;
//        int losses = 0;
//        try (Scanner fileReader = new Scanner(Paths.get(file))) {
//            while (fileReader.hasNextLine()) {
//                String line = fileReader.nextLine();
//                String homeTeam = "";
//                String visitorTeam = "";
//                int pointsHome = 0;
//                int pointsVisitor = 0;
//                if (line.contains(team)) {
//                    String[] parts = line.split(",");
//                    homeTeam = parts[0];
//                    visitorTeam = parts[1];
//                    pointsHome = Integer.valueOf(parts[2]);
//                    pointsVisitor = Integer.valueOf(parts[3]);
//                    count++;
//                    if (homeTeam.equals(team) && pointsHome > pointsVisitor) {
//                        wins++;
//                    } else if (visitorTeam.equals(team) && pointsHome < pointsVisitor) {
//                        wins++;
//                    } else {
//                        losses++;
//                    }
//                }
//            }
//        } catch (Exception e) {
//            System.out.println("Failed to read from file.");
//        }
//        System.out.println("Games: " + count);
//        System.out.println("Wins: " + wins);
//        System.out.println("Losses: " + losses);
    }

    public static ArrayList<Game> readFile(String fileName) {
        ArrayList<Game> games = new ArrayList<>();
        try (Scanner fileReader = new Scanner(Paths.get(fileName))) {
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                if (line.isEmpty()) {
                    continue;
                }
                String[] parts = line.split(",");
                String home = parts[0];
                String visitor = parts[1];
                int homeP = Integer.valueOf(parts[2]);
                int visitorP = Integer.valueOf(parts[3]);
                Game game = new Game(home, visitor, homeP, visitorP);
                games.add(game);
            }
        } catch (Exception e) {
            System.out.println("Failed to read from file.");
        }
        return games;
    }
}
