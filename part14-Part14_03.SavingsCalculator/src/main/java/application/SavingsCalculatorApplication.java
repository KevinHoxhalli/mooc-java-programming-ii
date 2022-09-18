package application;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SavingsCalculatorApplication extends Application{

    public static void main(String[] args){
        System.out.println("Hello world!");
        launch(SavingsCalculatorApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane layout = new BorderPane();
        
        NumberAxis xAxis= new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis();
        //linechart
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Savings Calculator Application");
        layout.setCenter(lineChart);
        //vbox
        VBox vbox = new VBox();
        BorderPane savings = new BorderPane();
        BorderPane interest = new BorderPane();
        vbox.getChildren().addAll(savings, interest);
        layout.setTop(vbox);
        
        //monthly savings
        Label labelMonthly = new Label("Monthly savings");
        Slider sliderSavings = new Slider(25, 250, 25);
        sliderSavings.setShowTickLabels(true);
        sliderSavings.setShowTickMarks(true);
        Label labelSavings = new Label(Double.toString(sliderSavings.getValue()));
        savings.setLeft(labelMonthly);
        savings.setCenter(sliderSavings);
        savings.setRight(labelSavings);
        
        //interest  
        Label labelYearly = new Label("Yearly interest rate");
        Slider sliderInterest = new Slider(0,10,0.1);
        sliderInterest.setShowTickLabels(true);
        Label labelInterest = new Label(Double.toString(sliderInterest.getValue()));
        interest.setLeft(labelYearly);
        interest.setCenter(sliderInterest);
        interest.setRight(labelInterest);
        
        Interest in = new Interest(sliderSavings.getValue(), sliderInterest.getValue());

        //actions
        sliderSavings.valueProperty().addListener((change, oldValue, newValue) -> {
            double value = Double.parseDouble(new DecimalFormat("##.##").format(newValue));
            labelSavings.setText(Double.toString(value));
            in.setSaving(value);
            lineChart.getData().clear();
            Map<String, Map<Integer, Double>> calculations = new HashMap<>();
            //calculations.put("With Interest", in.calculateWithInterest());
            calculations.put("Without Interest", in.calculateWithoutInterest());
            
            

            calculations.keySet().stream().forEach(calc -> {
                XYChart.Series data = new XYChart.Series();
                data.setName(calc);

                calculations.get(calc).entrySet().stream().forEach(pair -> {
                    data.getData().add(new XYChart.Data(pair.getKey(), pair.getValue()));
                });
                lineChart.getData().add(data);
            });
        });
        
        sliderInterest.valueProperty().addListener((change, oldValue, newValue) -> {
            double value = Double.parseDouble(new DecimalFormat("##.##").format(newValue));
            labelInterest.setText(Double.toString(value));
            in.setInterest(value);
            lineChart.getData().clear();
            Map<String, Map<Integer, Double>> calculations = new HashMap<>();
            calculations.put("With Interest", in.calculateWithInterest());
            calculations.put("Without Interest", in.calculateWithoutInterest());
            
            

            calculations.keySet().stream().forEach(calc -> {
                XYChart.Series data = new XYChart.Series();
                data.setName(calc);

                calculations.get(calc).entrySet().stream().forEach(pair -> {
                    data.getData().add(new XYChart.Data(pair.getKey(), pair.getValue()));
                });
                lineChart.getData().add(data);
            });
        });
        /*
        Map<String, Map<Integer, Double>> calculations = new HashMap<>();
            calculations.put("With Interest", in.calculateWithInterest());
            calculations.put("Without Interest", in.calculateWithoutInterest());
            
            

        calculations.keySet().stream().forEach(calc -> {
            XYChart.Series data = new XYChart.Series();

            data.setName(calc);

            calculations.get(calc).entrySet().stream().forEach(pair -> {
                data.getData().add(new XYChart.Data(pair.getKey(), pair.getValue()));
            });
            lineChart.getData().add(data);
        });*/
        
        
        
        
        Scene scene = new Scene(layout, 700 ,500);
        stage.setScene(scene);
        stage.show();
    }


    
    public void CalculateLineChart() {
        
    }

}
