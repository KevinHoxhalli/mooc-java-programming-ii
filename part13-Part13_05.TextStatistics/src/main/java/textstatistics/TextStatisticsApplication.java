package textstatistics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class TextStatisticsApplication extends Application{


    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(TextStatisticsApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane layout = new BorderPane();
        layout.setCenter(new TextArea(""));
        
        HBox hb = new HBox();
        hb.setSpacing(10);
        hb.getChildren().add(new Label("Letters: 0"));
        hb.getChildren().add(new Label("Words: 0"));
        hb.getChildren().add(new Label("The longest word is:"));
        
        layout.setBottom(hb);
        
        Scene view = new Scene(layout);
        
        stage.setScene(view);
        stage.show();
    }

}
