package fx.com;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        AnchorPane anchorPane1 = new AnchorPane();

        anchorPane1.setStyle("-fx-background-color: green");

        AnchorPane anchorPane2 = new AnchorPane();

        anchorPane2.setStyle("-fx-background-color: blue");

        anchorPane1.getChildren().addAll(anchorPane2);

        anchorPane1.setTopAnchor(anchorPane2, 0.0);
        anchorPane1.setLeftAnchor(anchorPane2, 0.0);

        anchorPane2.setPrefWidth(300);
        anchorPane2.setPrefHeight(270);


        Scene scene = new Scene(anchorPane1);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Miko is a lovely AI?");
        primaryStage.setWidth(600);
        primaryStage.setHeight(550);
        primaryStage.show();
    }
}
