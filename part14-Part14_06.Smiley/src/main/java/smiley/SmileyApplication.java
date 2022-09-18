package smiley;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class SmileyApplication extends Application{


    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(SmileyApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        BorderPane layout = new BorderPane();
        Canvas canvas = new Canvas(400,400);
        GraphicsContext colorPalette = canvas.getGraphicsContext2D();
        
        layout.setCenter(canvas);
        colorPalette.fillRect(40,40,20,20);
        colorPalette.fillRect(100,40,20,20);
        colorPalette.fillRect(20,100,20,20);
        colorPalette.fillRect(40,120,20,20);
        colorPalette.fillRect(60,120,20,20);
        colorPalette.fillRect(80,120,20,20);
        colorPalette.fillRect(100,120,20,20);
        colorPalette.fillRect(120,100,20,20);
        
        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.show();
    }
    

}
