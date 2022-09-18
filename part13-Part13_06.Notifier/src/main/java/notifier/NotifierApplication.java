package notifier;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class NotifierApplication extends Application{


    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(NotifierApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        VBox v = new VBox();
        TextField up = new TextField();
        Button btn = new Button("Update");
        Label down = new Label();
        
        btn.setOnAction((ActionEvent t) -> {
            down.setText(up.getText());    
        });
        
        v.getChildren().addAll(up, btn, down);
        
        Scene scene = new Scene(v);
        
        stage.setScene(scene);
        stage.show();
    }

}
