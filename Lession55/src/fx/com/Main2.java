package fx.com;

import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class Main2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color: #0FFFFF");

        TextField textField = new TextField();
        TextField textField1 = new TextField();

        anchorPane.setTopAnchor(textField, 100.0);
        anchorPane.setTopAnchor(textField1, 100.0);

        anchorPane.setLeftAnchor(textField, 10.0);
        anchorPane.setLeftAnchor(textField1, 200.0);

        anchorPane.getChildren().addAll(textField, textField1);

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Miko is lovely AI?");
        primaryStage.setWidth(800);
        primaryStage.setHeight(650);
        primaryStage.show();

//        textField.textProperty().addListener(new ChangeListener<String>() {
//            @Override
//            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
//                textField1.setText(newValue);
//            }
//        });

//        textField1.textProperty().bindBidirectional(textField.textProperty());

//        textField1.textProperty().bind(textField.textProperty());

        textField1.textProperty().bindBidirectional(textField.textProperty(), new StringConverter<String>() {
            @Override
            public String toString(String object) {
                return object;
            }

            @Override
            public String fromString(String string) {

                if (string.contains("qwq")) {
                    string = string.replace("qwq", "QwQ");
                }

                return string;
            }
        });

    }
}
