package buttonandlabel;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class ButtonAndLabelApplication extends Application{


    public static void main(String[] args) {
        launch(ButtonAndLabelApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Button btn = new Button("Button");
        Label lab = new Label("label");
        
        FlowPane componentGroup = new FlowPane();
        componentGroup.getChildren().add(lab);
        componentGroup.getChildren().add(btn);
        
        Scene view = new Scene(componentGroup);
        stage.setScene(view);
        stage.show();
    }

}
