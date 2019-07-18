package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

        ComboBox<String> comboBox = new ComboBox<String>();
        comboBox.getItems().addAll("Cute - 00", "Cute - 01", "Cute - 02");

        comboBox.setConverter(new StringConverter<String>() {
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

        comboBox.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> param) {
                My_ListCell<String> listCell = new My_ListCell<String>();
//                param.getItems().forEach(System.out::println);
//                param.getItems().forEach(item -> System.out.println("[Data] " + item));
//                param.getItems().forEach(item -> listCell.setText(item));
                return listCell;
            }
        });

        comboBox.setPrefWidth(150);
        AnchorPane.setTopAnchor(comboBox, 100.0);
        AnchorPane.setLeftAnchor(comboBox, 10.0);

        anchorPane.getChildren().addAll(comboBox);

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Miko is lovely AI?");
        primaryStage.setWidth(800);
        primaryStage.setHeight(650);
        primaryStage.show();

    }
}
class My_ListCell<T> extends ListCell<String> {
    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);

        if (empty) {
            return;
        }

        System.out.println("[empty] " + empty + "  [item]" + item);

        HBox hBox1 = new HBox(10);
        hBox1.setAlignment(Pos.CENTER);
//        hBox1.setMaxWidth(220);
//        hBox1.setMaxHeight(220);
        hBox1.setStyle("-fx-background-color: #FF82AB");
        hBox1.getChildren().addAll(new Button(item), new Button(item));

        this.setStyle("-fx-background-color: #B0E0E6");
        this.setGraphic(hBox1);
//        this.setPrefWidth(350);
//        this.setPrefHeight(350);
        this.setAlignment(Pos.CENTER);
        this.setContentDisplay(ContentDisplay.RIGHT);
    }
}