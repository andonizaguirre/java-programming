package application;

import java.util.HashMap;
import java.util.Map;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class ShanghaiApplication extends Application {

    public void start(Stage window) {
        NumberAxis xAxis = new NumberAxis(2006, 2018, 2);
        NumberAxis yAxis = new NumberAxis(0, 100, 10);
        xAxis.setLabel("Year");
        yAxis.setLabel("Ranking");
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("University of Helsinki, Shanghai Ranking");
        XYChart.Series rankingData = new XYChart.Series();
        Map<Integer, Integer> ranking = new HashMap<>();
        String input = "2007 73\n"
                + "2008 68\n"
                + "2009 72\n"
                + "2010 72\n"
                + "2011 74\n"
                + "2012 73\n"
                + "2013 76\n"
                + "2014 73\n"
                + "2015 67\n"
                + "2016 56\n"
                + "2017 56";
        String[] tokens = input.split("\n");
        for (String token : tokens) {
            String[] parts = token.split(" ");
            ranking.put(Integer.valueOf(parts[0]), Integer.valueOf(parts[1]));
        }
        ranking.entrySet().stream().forEach(pair -> {
            rankingData.getData().add(new XYChart.Data(pair.getKey(), pair.getValue()));
        });
        lineChart.getData().add(rankingData);
//        lineChart.setLegendVisible(false); // Zero below
        Scene view = new Scene(lineChart); // Adding component without layout
        window.setScene(view);
        window.setTitle("Shanghai Ranking");
        window.show();
    }
 
    public static void main(String[] args) {
        launch(ShanghaiApplication.class);
    }
}
