package ticTacToe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class TicTacToeApplication extends Application{

    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane layout = new BorderPane();
        //turn label
        Label turnLabel = new Label("Turn: X");
        turnLabel.setFont(Font.font("Monospaced", 40));
        
        layout.setTop(turnLabel);
        
        //tic tac toe button grid
        GridPane grid = new GridPane();
        Button btn1 = new Button("");
        Button btn2 = new Button("");
        Button btn3 = new Button("");
        Button btn4 = new Button("");
        Button btn5 = new Button("");
        Button btn6 = new Button("");
        Button btn7 = new Button("");
        Button btn8 = new Button("");
        Button btn9 = new Button("");
        //buttons font change
        btn1.setFont(Font.font("Monospaced", 40));
        btn2.setFont(Font.font("Monospaced", 40));
        btn3.setFont(Font.font("Monospaced", 40));
        btn4.setFont(Font.font("Monospaced", 40));
        btn5.setFont(Font.font("Monospaced", 40));
        btn6.setFont(Font.font("Monospaced", 40));
        btn7.setFont(Font.font("Monospaced", 40));
        btn8.setFont(Font.font("Monospaced", 40));
        btn9.setFont(Font.font("Monospaced", 40));
        //grid add btn
        grid.add(btn1, 0, 0);
        grid.add(btn2, 0, 1);
        grid.add(btn3, 0, 2);
        grid.add(btn4, 1, 0);
        grid.add(btn5, 1, 1);
        grid.add(btn6, 1, 2);
        grid.add(btn7, 2, 0);
        grid.add(btn8, 2, 1);
        grid.add(btn9, 2, 2);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);
        
        //btn actions
        btn1.setOnAction(event ->  newButton(btn1,grid,turnLabel));
        btn2.setOnAction(event ->  newButton(btn2,grid,turnLabel));
        btn3.setOnAction(event ->  newButton(btn3,grid,turnLabel));
        btn4.setOnAction(event ->  newButton(btn4,grid,turnLabel));
        btn5.setOnAction(event ->  newButton(btn5,grid,turnLabel));
        btn6.setOnAction(event ->  newButton(btn6,grid,turnLabel));
        btn7.setOnAction(event ->  newButton(btn7,grid,turnLabel));
        btn8.setOnAction(event ->  newButton(btn8,grid,turnLabel));
        btn9.setOnAction(event ->  newButton(btn9,grid,turnLabel));
        
        layout.setCenter(grid);
        layout.setPadding(new Insets(10,10,10,10));
        
        Scene scene = new Scene(layout, 400, 300);
        stage.setScene(scene);
        stage.show();
    }
    
    public void newButton(Button btnX,GridPane grid, Label turnLabel) {
        if(!btnX.getText().isEmpty() || turnLabel.getText().equals("The end!")) {
                return;
            }
        Button btn = null;
        if(turnLabel.getText().contains("X")) { 
            //btn = new Button("X");
            btnX.setText("X");
            //btn.setFont(Font.font("Monospaced", 40));
            turnLabel.setText("Turn: O");
        } else if(turnLabel.getText().contains("O")) {
            //btn = new Button("O"); 
            btnX.setText("O");
            //btn.setFont(Font.font("Monospaced", 40));
            turnLabel.setText("Turn: X");
        }
        //int x = grid.getRowIndex(btnX);
        //int y = grid.getColumnIndex(btnX);
        
        //grid.clearConstraints(btnX);
        //grid.getChildren().remove(btnX);
        //grid.add(btn, y, x);
        
        checkGame(btnX,grid,turnLabel);
        
    }
    
    public void checkGame(Button btnX, GridPane grid, Label turnLabel) {
        int x = grid.getRowIndex(btnX);
        int y = grid.getColumnIndex(btnX);
        
        Button bnX1 = (Button)getNodeFromGridPane(grid,y,0);
        Button bnX2 = (Button)getNodeFromGridPane(grid,y,1);
        Button bnX3 = (Button)getNodeFromGridPane(grid,y,2);
        
        Button bnY1 = (Button)getNodeFromGridPane(grid,0,x);
        Button bnY2 = (Button)getNodeFromGridPane(grid,1,x);
        Button bnY3 = (Button)getNodeFromGridPane(grid,2,x);
        
        if(bnX1.getText().equals(bnX2.getText()) && bnX1.getText().equals(bnX3.getText()) &&  bnX3.getText().equals(bnX2.getText()) && !bnX1.getText().isEmpty()) {
            turnLabel.setText("The end!");
        }
        if(bnY1.getText().equals(bnY2.getText()) && bnY1.getText().equals(bnY3.getText()) &&  bnY3.getText().equals(bnY2.getText()) && !bnY1.getText().isEmpty()) {
            turnLabel.setText("The end!");
        }
        
        Button d1 = (Button)getNodeFromGridPane(grid,0,0);
        Button d2 = (Button)getNodeFromGridPane(grid,1,1);
        Button d3 = (Button)getNodeFromGridPane(grid,2,2);
        Button d4 = (Button)getNodeFromGridPane(grid,2,0);
        Button d5 = (Button)getNodeFromGridPane(grid,0,2);

        if(d1.getText().equals(d2.getText()) && d1.getText().equals(d3.getText()) &&  d3.getText().equals(d2.getText()) && !d1.getText().isEmpty()) {
            turnLabel.setText("The end!");
        } else if(d2.getText().equals(d4.getText()) && d2.getText().equals(d5.getText()) &&  d4.getText().equals(d5.getText()) && !d2.getText().isEmpty()) {
            turnLabel.setText("The end!");
        }

        
    }
    
    private Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                return node;
            }
        }
        return null;
    }
    

    


}
