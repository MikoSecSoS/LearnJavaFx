package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
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
import javafx.util.StringConverter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Main2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Button sortBut = new Button("Sort");

        ObservableList<String> list = FXCollections.observableArrayList();
        list.addAll("Miko", "Code");

        ObservableList<String> list1 = FXCollections.observableArrayList();
        list1.addAll("Cute", "Lovely", "Low", "AI");

        ObservableList<String> list2 = FXCollections.observableArrayList();
        list2.addAll("233", "555","111", "222");

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color: #EECFA1");

        ChoiceBox<String> choiceBox = new ChoiceBox<String>();
        choiceBox.getItems().addAll(list);

        ChoiceBox<String> choiceBox1 = new ChoiceBox<String>();



        choiceBox.setPrefWidth(150);
        choiceBox1.setPrefWidth(150);

        AnchorPane.setTopAnchor(choiceBox, 100.0);
        AnchorPane.setLeftAnchor(choiceBox, 10.0);

        AnchorPane.setTopAnchor(choiceBox1, 100.0);
        AnchorPane.setLeftAnchor(choiceBox1, 200.0);

        anchorPane.getChildren().addAll(choiceBox, choiceBox1, sortBut);

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Miko is lovely AI?");
        primaryStage.setWidth(800);
        primaryStage.setHeight(650);
        primaryStage.show();

        choiceBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.equals("Miko")) {
                    choiceBox1.setItems(list1);
                } else if (newValue.equals("Code")) {
                    choiceBox1.setItems(list2);
                }
                choiceBox1.show();
            }
        });

        sortBut.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                list2.sort(new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        int i = Integer.valueOf(o1);
                        int j = Integer.valueOf(o2);

                        return j - i;
                    }
                });
            }
        });
    }
}
