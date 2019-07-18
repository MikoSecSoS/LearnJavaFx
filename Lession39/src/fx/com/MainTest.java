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

public class MainTest extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {


        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color: #EECFA1");

        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.setMaxWidth(220);
        hBox.setMaxHeight(220);
        hBox.setStyle("-fx-background-color: #FFE100");
        hBox.getChildren().addAll(new Button("[Cute - 00]"), new Button("[Cute - 01]"));

        Label label = new Label();
//        label.setText("Label 1");
        label.setStyle("-fx-background-color: blue");
        label.setGraphic(hBox);
        label.setPrefWidth(350);
        label.setPrefHeight(350);
        label.setAlignment(Pos.CENTER);
        label.setContentDisplay(ContentDisplay.RIGHT);


        HBox hBox1 = new HBox(10);
        hBox1.setAlignment(Pos.CENTER);
        hBox1.setMaxWidth(220);
        hBox1.setMaxHeight(220);
        hBox1.setStyle("-fx-background-color: #FF82AB");
        hBox1.getChildren().addAll(new Button("[Cute - 00]"), new Button("[Cute - 01]"));

        ListCell<String> listCell = new ListCell<String>();
        listCell.setStyle("-fx-background-color: #B0E0E6");
        listCell.setGraphic(hBox1);
        listCell.setPrefWidth(350);
        listCell.setPrefHeight(350);
        listCell.setAlignment(Pos.CENTER);
        listCell.setContentDisplay(ContentDisplay.RIGHT);

        MyListCell<String> myListCell = new MyListCell<String>();
        myListCell.updateItem("[qwq]", true);

        AnchorPane.setTopAnchor(label, 100.0);
        AnchorPane.setLeftAnchor(label, 30.0);

        AnchorPane.setTopAnchor(listCell, 100.0);
        AnchorPane.setLeftAnchor(label, 230.0);

        AnchorPane.setTopAnchor(listCell, 100.0);
        AnchorPane.setLeftAnchor(label, 430.0);

        anchorPane.getChildren().addAll(label);
//        anchorPane.getChildren().addAll(label, listCell);
//        anchorPane.getChildren().addAll(label, myListCell);

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Miko is lovely AI?");
        primaryStage.setWidth(900);
        primaryStage.setHeight(650);
        primaryStage.show();

    }
}

class MyListCell<T> extends ListCell<String> {
    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        HBox hBox1 = new HBox(10);
        hBox1.setAlignment(Pos.CENTER);
        hBox1.setMaxWidth(220);
        hBox1.setMaxHeight(220);
        hBox1.setStyle("-fx-background-color: #FF82AB");
        hBox1.getChildren().addAll(new Button(item), new Button(item));

        this.setStyle("-fx-background-color: #B0E0E6");
        this.setGraphic(hBox1);
        this.setPrefWidth(350);
        this.setPrefHeight(350);
        this.setAlignment(Pos.CENTER);
        this.setContentDisplay(ContentDisplay.RIGHT);
    }
}