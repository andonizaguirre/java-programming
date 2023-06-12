package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SavingsCalculatorApplication extends Application {

    public void start(Stage window) {
        BorderPane layout = new BorderPane();
        Slider amountSlider = new Slider(25, 250, 25); // min, max, initialValue
//        amountSlider.setSnapToTicks(true); // Value snaps to one of the ticks, no intermediate values
        amountSlider.setShowTickLabels(true);
        amountSlider.setShowTickMarks(true);
        Slider rateSlider = new Slider(0, 10, 0);
        rateSlider.setShowTickLabels(true);
        rateSlider.setShowTickMarks(true);
        Label amountValue = new Label(String.format("%.0f", amountSlider.getValue()));
        Label rateValue = new Label(String.format("%.0f", rateSlider.getValue()));
        BorderPane amountDisplay = new BorderPane();
        amountDisplay.setLeft(new Label("Monthly savings"));
        amountDisplay.setCenter(amountSlider);
        amountDisplay.setRight(amountValue);
        amountDisplay.setPadding(new Insets(10));
        BorderPane rateDisplay = new BorderPane();
        rateDisplay.setLeft(new Label("Yearly interest rate"));
        rateDisplay.setCenter(rateSlider);
        rateDisplay.setRight(rateValue);
        rateDisplay.setPadding(new Insets(10));
        VBox slidersDisplay = new VBox();
        slidersDisplay.getChildren().addAll(amountDisplay, rateDisplay);
        slidersDisplay.setPadding(new Insets(10));
        slidersDisplay.setSpacing(10);
        layout.setTop(slidersDisplay);
        amountSlider.valueProperty().addListener((change, oldValue, newValue) -> amountValue.setText(String.format("%.0f", newValue))); // Real-time value changes
        rateSlider.valueProperty().addListener((change, oldValue, newValue) -> rateValue.setText(String.format("%.0f", newValue)));
        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Year");
        yAxis.setLabel("Savings");
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setAnimated(false); // No animation on data changes
        lineChart.setLegendVisible(false); // No legend
        lineChart.setTitle("Savings over time");
        layout.setCenter(lineChart);
        XYChart.Series savings = new XYChart.Series();
        XYChart.Series savingsWithInterest = new XYChart.Series();
        lineChart.getData().add(savings);
        lineChart.getData().add(savingsWithInterest);
        amountSlider.setOnMouseReleased(event -> this.updateCharts(amountSlider.getValue(), rateSlider.getValue(), savings, savingsWithInterest));
        rateSlider.setOnMouseReleased(event -> this.updateCharts(amountSlider.getValue(), rateSlider.getValue(), savings, savingsWithInterest));
        Scene view = new Scene(layout, 640, 480);
        window.setScene(view);
        window.setTitle("Savings calculator");
        window.show();
    }

    private void updateCharts(double amount, double rate, XYChart.Series savings, XYChart.Series savingsWithInterest) { // Update both charts when one slider changes
        savings.getData().clear();
        savingsWithInterest.getData().clear();
        double accumulated = 0;
        double accumulatedWithRate = 0;
        for (int i = 0; i < 31; i++) { // 30 years, including year zero
            savings.getData().add(new XYChart.Data(i, accumulated));
            accumulated = accumulated + amount * 12;
//            savings.getData().add(new XYChart.Data(i, i * amount * 12)); // Equivalent
            savingsWithInterest.getData().add(new XYChart.Data(i, accumulatedWithRate));
            accumulatedWithRate = ((accumulatedWithRate + amount * 12) * (1 + rate / 100));
        }
    }

    public static void main(String[] args) {
        launch(SavingsCalculatorApplication.class);
    }
}
