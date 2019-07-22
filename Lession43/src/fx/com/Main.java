package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {


        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color: #EECFA1");

        ColorPicker colorPicker = new ColorPicker();
        colorPicker.setPrefWidth(150);

        anchorPane.getChildren().addAll(colorPicker);

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Miko is lovely AI?");
        primaryStage.setWidth(800);
        primaryStage.setHeight(650);
        primaryStage.show();

        colorPicker.valueProperty().addListener(new ChangeListener<Color>() {
            @Override
            public void changed(ObservableValue<? extends Color> observable, Color oldValue, Color newValue) {
                System.out.println("[Red] " + newValue.getRed());
                System.out.println("[Green] " + newValue.getGreen());
                System.out.println("[Blue] " + newValue.getBlue());

                String value = newValue.toString().substring(2);

                System.out.println("[Color] " + value);

                anchorPane.setStyle("-fx-background-color: #"+value);

            }
        });


    }
}