package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GreeterApplication extends Application{


    public static void main(String[] args) {
        System.out.println("Hellow world! :3");
        launch(GreeterApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        //scene 1
        Label l1 = new Label("Enter your name and start");
        TextField textfield = new TextField();
        Button start = new Button("Start");
        VBox vbox = new VBox();
        vbox.getChildren().addAll(l1,textfield,start);
        vbox.setSpacing(10);
        vbox.setPrefSize(300, 180);
        vbox.setAlignment(Pos.CENTER);
        //scene2
        Label welcomeText = new Label("Welcome ");
        StackPane welcomeLayout = new StackPane();
        welcomeLayout.setPrefSize(300, 180);
        welcomeLayout.getChildren().add(welcomeText);
        welcomeLayout.setAlignment(Pos.CENTER);
        
        Scene scene1 = new Scene(vbox);
        Scene scene2 = new Scene(welcomeLayout); 
        
        start.setOnAction((event) -> {
            welcomeText.setText("Welcome "+textfield.getText()+"!");
            stage.setScene(scene2);
        });
        
        stage.setScene(scene1);
        stage.show();
    }
}
