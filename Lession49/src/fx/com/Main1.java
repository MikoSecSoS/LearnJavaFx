package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color: #0FFFFF");

        VBox vBoxHbox = new VBox();

        HBox hBox = new HBox(10);

        for (int i = 0; i < 10; i++) {
            hBox.getChildren().add(new Button("[Button Cute] " + i));
        }

        VBox vBox = new VBox(10);

        for (int i = 0; i < 10; i++) {
            vBox.getChildren().add(new Button("[Lovely Button] " + i));
        }

        vBoxHbox.getChildren().addAll(hBox, vBox);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setPrefWidth(300);
        scrollPane.setPrefHeight(300);

        scrollPane.setContent(vBoxHbox);

        anchorPane.getChildren().addAll(scrollPane);

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Miko is lovely AI?");
        primaryStage.setWidth(800);
        primaryStage.setHeight(650);
        primaryStage.show();

        scrollPane.hvalueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println(newValue);
            }
        });

    }
}