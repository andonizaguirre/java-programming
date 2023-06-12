package application;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class PartiesApplication extends Application {

    public void start(Stage window) {
        NumberAxis xAxis = new NumberAxis(1964, 2012, 4);
        NumberAxis yAxis = new NumberAxis(0, 30, 5);
        xAxis.setLabel("Year");
        yAxis.setLabel("Relative support (%)");
        LineChart lineChart = new LineChart(xAxis, yAxis);
        lineChart.setTitle("Relative support in the years 1968-2008");
        Map<String, Map<Integer, Double>> partiesData = obtainPartiesData(this.readFile());
        partiesData.keySet().stream().forEach(party -> {
            XYChart.Series data = new XYChart.Series();
            data.setName(party);
            partiesData.get(party).entrySet().stream().forEach(pair -> {
                data.getData().add(new XYChart.Data(pair.getKey(), pair.getValue()));
            });
            lineChart.getData().add(data);
        });
        /*
        Could be done without the use of a Map
        for (int i = 1; i < rows.size(); i++) { // Skip header
            String[] row = rows.get(i); 
            XYChart.Series data = new XYChart.Series();
            data.setName(row[0]); // Set party name to data
            for (int column = 1; column < row.length; column++) { // Skip party name
                String value = row[column];
                if (value.equals("-")) {
                    continue;
                } 
                int year = Integer.parseInt(rows.get(0)[column]); 
                data.getData().add(new XYChart.Data(year, Double.parseDouble(value)));
            } 
            lineChart.getData().add(data); 
        }
         */
        Scene view = new Scene(lineChart); // No layout
        window.setScene(view);
        window.setTitle("Finnish Parties");
        window.show();
    }

    private List<String> readFile() {
        List<String> fileRows = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(Paths.get("partiesdata.tsv"));
            while (scanner.hasNextLine()) {
                String row = scanner.nextLine();
                fileRows.add(row);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return fileRows;
        /*
        List<String[]> rows = new ArrayList<>(); // Could return the list containing the parts already
        try {
            Files.lines(Paths.get("partiesdata.tsv")).map(line -> line.split("\t")).forEach(parts -> rows.add(parts)); // Files reads file into stream
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());            
        }
         */
    }

    private Map<String, Map<Integer, Double>> obtainPartiesData(List<String> fileRows) {
        Map<String, Map<Integer, Double>> partiesData = new HashMap<>(); // Map with parties and mapped votes as values
        String[] header = fileRows.get(0).split("\t"); //Years are in the header (first row)
        for (int i = 1; i < fileRows.size(); i++) { // i = 1 to skip header
            String row = fileRows.get(i);
            if (row.isBlank()) { // Skip blank line
                continue;
            }
            Map<Integer, Double> votesData = new HashMap<>(); // Map for each partie
            String[] tokens = row.split("\t");
            for (int j = 1; j < tokens.length; j++) { // i = 1 to skip the first column
                if (tokens[j].equals("-")) { // Skip missing values
                    continue;
                }
                votesData.put(Integer.valueOf(header[j]), Double.valueOf(tokens[j])); // year, votes
            }
            partiesData.put(tokens[0], votesData);
        }
        return partiesData;
    }

    public static void main(String[] args) {
        launch(PartiesApplication.class);
    }
}
