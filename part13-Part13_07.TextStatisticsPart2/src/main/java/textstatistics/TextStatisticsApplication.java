package textstatistics;

import java.util.Arrays;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextStatisticsApplication extends Application {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(TextStatisticsApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane layout = new BorderPane();
        TextArea leftText = new TextArea();
        layout.setCenter(leftText);

        Label l1 = new Label("Letters: 0");
        Label l2 = new Label("Words: 0");
        Label l3 = new Label("The longest word is: ");
        HBox hb = new HBox();
        hb.setSpacing(10);
        hb.getChildren().add(l1);
        hb.getChildren().add(l2);
        hb.getChildren().add(l3);

        leftText.textProperty().addListener((change, oldValue, newValue) -> {
            int characters = newValue.length();
            String[] parts = newValue.split(" ");
            int words = parts.length;
            String longest = Arrays.stream(parts)
                .sorted((s1, s2) -> s2.length() - s1.length())
                .findFirst()
                .get();
            l1.setText("Letters: "+characters);
            l2.setText("Words: "+words);
            l3.setText("The longest word is: "+longest); 
        });
        
        

        layout.setBottom(hb);

        Scene view = new Scene(layout);

        stage.setScene(view);
        stage.show();
    }

}
