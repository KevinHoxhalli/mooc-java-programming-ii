package application;

import java.util.HashMap;
import java.util.Map;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class ShanghaiApplication extends Application{

    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(ShanghaiApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Map<Integer,Integer> helsinki = new HashMap<>();
        helsinki.put(2007,73);
        helsinki.put(2008,63);
        helsinki.put(2009,72);
        helsinki.put(2010,72);
        helsinki.put(2011, 74);
        helsinki.put(2012, 73);
        helsinki.put(2013, 76);
        helsinki.put(2014, 73);
        helsinki.put(2015, 67);
        helsinki.put(2016 ,56);
        helsinki.put(2017, 56);
        
        NumberAxis xAxis= new NumberAxis(2006, 2018, 2);
        NumberAxis yAxis = new NumberAxis(0, 100, 10);
        xAxis.setLabel("Year");
        yAxis.setLabel("Ranking");
        
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("University of Helsinki, Shanghai ranking");
        Map<String, Map<Integer, Integer>> rankings = new HashMap<>();
        rankings.put("Helsinki", helsinki);
        
        rankings.keySet().stream().forEach(university -> {
            XYChart.Series data = new XYChart.Series();
            data.setName(university);
            
            rankings.get(university).entrySet().stream().forEach(pair -> {
                data.getData().add(new XYChart.Data(pair.getKey(), pair.getValue()));
            });
            lineChart.getData().add(data);
        });
        
        Scene scene = new Scene(lineChart, 400 ,300);
        stage.setScene(scene);
        stage.show();
    }

}
