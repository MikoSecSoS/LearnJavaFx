package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Button button = new Button("[Lovely Button]");

        ComboBox<String> comboBox = new ComboBox<String>();
        comboBox.getItems().addAll("Cute - 0", "Cute - 1", "Cute - 2", "Cute - 3");

        comboBox.setEditable(true);
        comboBox.setPromptText("Input love miko.");

//        comboBox.setPlaceholder(new Button("[Cute]"));

        comboBox.setVisibleRowCount(2);

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color: #EECFA1");

        AnchorPane.setTopAnchor(comboBox, 100.0);
        AnchorPane.setLeftAnchor(comboBox, 10.0);

        anchorPane.getChildren().addAll(comboBox, button);

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Miko is lovely AI?");
        primaryStage.setWidth(800);
        primaryStage.setHeight(650);
        primaryStage.show();

        comboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println("[selectedItemProperty] " + newValue);
            }
        });

        comboBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("[setOnAction] " + event.getSource());
            }
        });
    }
}
