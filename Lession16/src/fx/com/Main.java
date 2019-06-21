package fx.com;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Button button1 = new Button("A Cute Button.");

        AnchorPane anchorPane1 = new AnchorPane();
        anchorPane1.setPrefWidth(100);
        anchorPane1.setPrefHeight(100);
        anchorPane1.setStyle("fx-background-color: #EE6AA7");

//        AnchorPane anchorPane2 = new AnchorPane();
//        anchorPane2.setPrefWidth(100);
//        anchorPane2.setPrefHeight(100);
//        anchorPane2.setStyle("fx-background-color: #98FB98");
//
//        AnchorPane anchorPane3 = new AnchorPane();
//        anchorPane3.setPrefWidth(100);
//        anchorPane3.setPrefHeight(100);
//        anchorPane3.setStyle("fx-background-color: #A0522D");
//
//        AnchorPane anchorPane4 = new AnchorPane();
//        anchorPane4.setPrefWidth(100);
//        anchorPane4.setPrefHeight(100);
//        anchorPane4.setStyle("fx-background-color: #1E90FF");
//
//        AnchorPane anchorPane5 = new AnchorPane();
//        anchorPane5.setPrefWidth(100);
//        anchorPane5.setPrefHeight(100);
//        anchorPane5.setStyle("fx-background-color: #EEEE00");


        BorderPane borderPane = new BorderPane();

        borderPane.setStyle("-fx-background-color: #B23AEE");

        borderPane.setTop(anchorPane1);
//        borderPane.setBottom(anchorPane2);
//        borderPane.setLeft(anchorPane3);
//        borderPane.setRight(anchorPane4);
//        borderPane.setCenter(anchorPane5);

        Scene scene = new Scene(borderPane);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Miko is lovely AI?");
        primaryStage.setWidth(600);
        primaryStage.setHeight(550);
        primaryStage.show();
    }
}
