package fx.com;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {


        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color: #EECFA1");

        ChoiceBox<String> choiceBox = new ChoiceBox<String>();
        choiceBox.getItems().addAll("Cute - 00", "Cute - 01", "Cute - 02");

        choiceBox.setConverter(new StringConverter<String>() {
            @Override
            public String toString(String object) {
//                System.out.println(object);
                return object;
            }

            @Override
            public String fromString(String string) {
                return null;
            }
        });

        choiceBox.setPrefWidth(150);
        AnchorPane.setTopAnchor(choiceBox, 100.0);
        AnchorPane.setLeftAnchor(choiceBox, 10.0);

        anchorPane.getChildren().addAll(choiceBox);

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Miko is lovely AI?");
        primaryStage.setWidth(800);
        primaryStage.setHeight(650);
        primaryStage.show();



    }
}