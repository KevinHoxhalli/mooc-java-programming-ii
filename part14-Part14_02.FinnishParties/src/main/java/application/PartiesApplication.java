package application;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class PartiesApplication extends Application{

    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(PartiesApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Map<String,Map<Integer, Double>> parties = new HashMap<>();
        //reading file to map
        try(Scanner scanner = new Scanner(new File("partiesdata.tsv"))) {
            String partyDates = scanner.nextLine();
            
            String[] datesParts = partyDates.split("\t"); 
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\t");   
                Map<Integer, Double> party = new HashMap<>();
                for(int i=1; i<parts.length; i++) {
                    if(parts[i].trim().equals("-")) {
                        continue;
                    }        
                    party.put(Integer.valueOf(datesParts[i]), Double.valueOf(parts[i]));
                }
                parties.put(parts[0], party);
                
            }
        }catch(Exception e) {
            System.out.println("Error: " + e.getMessage());        
        }
        System.out.println(parties);
        
        NumberAxis xAxis= new NumberAxis(1968, 2008, 4);
        NumberAxis yAxis = new NumberAxis(0, 30, 5);
        xAxis.setLabel("Year");
        yAxis.setLabel("Relative Support");
        
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Relative support of the parites");
        
        parties.keySet().stream().forEach(party -> {
            XYChart.Series data = new XYChart.Series();
            data.setName(party);
            
            parties.get(party).entrySet().stream().forEach(pair -> {
                data.getData().add(new XYChart.Data(pair.getKey(), pair.getValue()));
            });
            lineChart.getData().add(data);
        });
        
        Scene scene = new Scene(lineChart, 400 ,300);
        stage.setScene(scene);
        stage.show();
    }
}


