package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleViews extends Application{

    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(MultipleViews.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        //scene 1 components
        BorderPane border = new BorderPane();
        Button btn1 = new Button("To the second view!");
        Label l1 = new Label("First view!");
        border.setTop(l1);
        border.setCenter(btn1);
        
        //scene 2 components
        VBox vbox = new VBox();
        Button btn2 = new Button("To the third view!");
        vbox.getChildren().addAll(btn2, new Label("Second view!"));
        //scene 3 components
        GridPane grid = new GridPane();
        Label l3 = new Label("Third view!");
        Button btn3 = new Button("To the third view!");
        grid.setConstraints(l3, 0, 0);
        grid.setConstraints(btn3, 1, 1);
        grid.getChildren().addAll(l3, btn3);
        //scenes
        Scene scene1 = new Scene(border);
        Scene scene2 = new Scene(vbox);
        Scene scene3 = new Scene(grid);
        //button handlres
        btn1.setOnAction((event) -> {
            stage.setScene(scene2);
        });
        btn2.setOnAction((event) -> {
            stage.setScene(scene3);
        });
        btn3.setOnAction((event) -> {
            stage.setScene(scene1);
        });
        stage.setScene(scene1);
        stage.show();
    }

}
