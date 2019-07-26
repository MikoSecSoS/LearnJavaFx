package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color: #0FFFFF");

        Button button = new Button("[Lovely Button 00]");
        Button button1 = new Button("[Lovely Button 01]");
        Button button2 = new Button("[Lovely Button 02]");
        Button button3 = new Button("[Lovely Button 03]");

        SplitPane splitPane = new SplitPane();
//        splitPane.setPrefHeight(500);

        StackPane stackPane = new StackPane();
        stackPane.setMaxWidth(250);
        stackPane.setMinWidth(50);
        stackPane.getChildren().add(button);

        StackPane stackPane1 = new StackPane();
        stackPane1.setStyle("-fx-background-color: #233333");
        stackPane1.getChildren().add(button1);

        StackPane stackPane2 = new StackPane();
        stackPane2.getChildren().add(button2);

        StackPane stackPane3 = new StackPane();
        stackPane3.getChildren().add(button3);

        splitPane.getItems().addAll(stackPane, stackPane1, stackPane2, stackPane3);

//        splitPane.setOrientation(Orientation.VERTICAL);

        splitPane.setDividerPosition(0, 0.25);
        splitPane.setDividerPosition(1, 0.50);
        splitPane.setDividerPosition(2, 0.75);
        splitPane.setDividerPosition(3, 1.00);

        anchorPane.getChildren().addAll(splitPane);

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Miko is lovely AI?");
        primaryStage.setWidth(800);
        primaryStage.setHeight(650);
        primaryStage.show();

        anchorPane.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                splitPane.setPrefWidth(newValue.doubleValue());
            }
        });
    }
}
