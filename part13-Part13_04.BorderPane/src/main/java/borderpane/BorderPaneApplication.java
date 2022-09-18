package borderpane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class BorderPaneApplication extends Application{


    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(BorderPaneApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane bp = new BorderPane();
        bp.setTop(new Label("NORTH"));
        bp.setRight(new Label("EAST"));
        bp.setBottom(new Label("SOUTH"));
        
        Scene scene = new Scene(bp);
        stage.setScene(scene);
        stage.show();
    }

}
