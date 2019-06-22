package fx.com;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
        Button button1 = new Button("A Lovely Button.");

        AnchorPane anchorPane1 = new AnchorPane();
        anchorPane1.setPrefWidth(100);
        anchorPane1.setPrefHeight(100);
        anchorPane1.setStyle("-fx-background-color: red");

        AnchorPane anchorPane2 = new AnchorPane();
        anchorPane2.setPrefWidth(100);
        anchorPane2.setPrefHeight(100);
        anchorPane2.setStyle("-fx-background-color: yellow");

        AnchorPane anchorPane3 = new AnchorPane();
        anchorPane3.setPrefWidth(100);
        anchorPane3.setPrefHeight(100);
        anchorPane3.setStyle("-fx-background-color: blue");

        AnchorPane anchorPane4 = new AnchorPane();
        anchorPane4.setPrefWidth(100);
        anchorPane4.setPrefHeight(100);
        anchorPane4.setStyle("-fx-background-color: green");

        AnchorPane anchorPane5 = new AnchorPane();
        anchorPane5.setPrefWidth(100);
        anchorPane5.setPrefHeight(100);
        anchorPane5.setStyle("-fx-background-color: black");


        BorderPane borderPane = new BorderPane();

        borderPane.setStyle("-fx-background-color: #B23AEE");

        borderPane.setTop(anchorPane1);
//        borderPane.setTop(button1);
        borderPane.setBottom(anchorPane2);
        borderPane.setLeft(anchorPane3);
//        borderPane.setRight(anchorPane4);
        borderPane.setCenter(anchorPane5);

//        borderPane.setPadding(new Insets(10));
//
//        borderPane.setMargin(anchorPane1, new Insets(10));
//
//        borderPane.setAlignment(borderPane, Pos.CENTER);
//
//        Button button2 = (Button)borderPane.getTop();
//
//        System.out.println(button2.getText());


        Scene scene = new Scene(borderPane);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Miko is lovely AI?");
        primaryStage.setWidth(650);
        primaryStage.setHeight(550);
        primaryStage.show();
    }
}
