package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color: #EECFA1");

        HBox hBox = new HBox(15);

        Button cbshow = new Button("show");
        Button cbhide = new Button("hide");

        ChoiceBox choiceBox = new ChoiceBox();
        choiceBox.getItems().addAll("[Cute] 00", new Separator(), "[Cute] 01", new Separator(), "[Cute] 02");

        choiceBox.setValue("[Cute] 00");

        choiceBox.getSelectionModel().select("[Cute] 01");

        choiceBox.getSelectionModel().selectPrevious();

        choiceBox.setPrefWidth(100);


        AnchorPane.setTopAnchor(choiceBox, 100.0);
        AnchorPane.setLeftAnchor(choiceBox, 10.0);

        hBox.getChildren().addAll(cbshow, cbhide);

        anchorPane.getChildren().addAll(choiceBox, hBox);

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Miko is lovely AI?");
        primaryStage.setWidth(800);
        primaryStage.setHeight(650);
        primaryStage.show();

        choiceBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println("[selectedItemProperty] => " + newValue);
            }
        });

        cbshow.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                choiceBox.show();
            }
        });

        cbhide.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                choiceBox.hide();
            }
        });

    }
}
