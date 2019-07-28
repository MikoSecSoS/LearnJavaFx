package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color: #0FFFFF");

        HBox hBox = new HBox(10);

        Button button = new Button("[Lovely Btn00]");
        Button button1 = new Button("[Lovely Btn01]");

        Separator separator = new Separator(Orientation.VERTICAL);
        separator.setPrefWidth(300);
        separator.setPrefHeight(300);

        separator.setHalignment(HPos.LEFT);

        separator.setStyle("-fx-background-color: #0000FF");

//        separator.setValignment(VPos.BOTTOM);

        hBox.getChildren().addAll(button, separator, button1);

        anchorPane.getChildren().addAll(hBox);

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Miko is lovely AI?");
        primaryStage.setWidth(800);
        primaryStage.setHeight(650);
        primaryStage.show();

    }
}