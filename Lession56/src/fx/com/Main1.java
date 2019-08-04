package fx.com;

import javafx.application.Application;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color: #0FFFFF");

        TextField textField = new TextField();

        Button button = new Button("[Cute]");

        anchorPane.getChildren().addAll(button, textField);

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Miko is lovely AI?");
        primaryStage.setWidth(800);
        primaryStage.setHeight(650);
        primaryStage.show();

        SimpleIntegerProperty simpleIntegerProperty = new SimpleIntegerProperty(2);

        DoubleBinding doubleBinding_widthProperty = anchorPane.widthProperty().divide(simpleIntegerProperty);
        DoubleBinding doubleBinding_heightProperty = anchorPane.heightProperty().divide(simpleIntegerProperty);

        button.prefWidthProperty().bind(doubleBinding_widthProperty);
        button.prefHeightProperty().bind(doubleBinding_heightProperty);

        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.isEmpty() && newValue.matches("[0-9]+")) {
                    int value = Integer.parseInt(newValue);
                    simpleIntegerProperty.set(value);
                } else {
                    textField.clear();
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("WARNING!!!");
                    alert.setHeaderText("WARNING.");
                    alert.setContentText("Please Input integer number.");
                    alert.showAndWait();
                }
            }
        });
    }
}
