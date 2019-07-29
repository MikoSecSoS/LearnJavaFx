package fx.com;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color: #0FFFFF");

        Button button = new Button("[Lovely Btn]");

        HBox hBox = new HBox();
        hBox.setStyle("-fx-background-color: #FFFF55");
        hBox.setAlignment(Pos.CENTER);
        hBox.setPrefWidth(200);
        hBox.setPrefHeight(200);
        hBox.getChildren().addAll(button);

        anchorPane.setTopAnchor(hBox, 100.0);
        anchorPane.setLeftAnchor(hBox, 100.0);

        anchorPane.getChildren().addAll(hBox);

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Miko is lovely AI?");
        primaryStage.setWidth(800);
        primaryStage.setHeight(650);
        primaryStage.setX(100);
        primaryStage.setY(100);
        primaryStage.show();

        System.out.println(button.getLayoutY());
        System.out.println(button.getLayoutX());

        Bounds bounds = button.getLayoutBounds();

        System.out.println("Left UP X:" + bounds.getMinX());
        System.out.println("Left UP Y:" + bounds.getMinY());

        System.out.println("Right Down X:" + bounds.getMaxX());
        System.out.println("Right Down Y:" + bounds.getMaxY());

        System.out.println("Width:" + bounds.getWidth());
        System.out.println("Height:" + bounds.getHeight());

        Point2D point2D = button.localToParent(bounds.getMinX(), bounds.getMinY());

        System.out.println("[In hBox(Parent) XY is] " + "X = " + point2D.getX() + " Y = " + point2D.getY());

        Point2D point2D1 = button.localToScene(bounds.getMinX(), bounds.getMinY());

        System.out.println("[In scene(Scene) XY is] " + "X = " + point2D1.getX() + " Y = " + point2D1.getY());

        Point2D point2D2 = button.localToScreen(bounds.getMinX(), bounds.getMinY());

        System.out.println("[In computerScreen(Screen) XY is] " + "X = " + point2D2.getX() + " Y = " + point2D2.getY());

        Point2D point2D3 = button.parentToLocal(point2D.getX(), point2D.getY());

        Point2D point2D4 = button.sceneToLocal(point2D.getX(), point2D.getY());

        System.out.println(point2D3);

        System.out.println(point2D4);

        System.out.println(bounds.contains(10, 10));

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
//                for (int i = 0; i < 10; i++) {
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                    Double x = (Double)Math.random()*700;
//                    Double y = (Double)Math.random()*550;
//                    System.out.println("X = " + x);
//                    System.out.println("Y = " + y);
//                    primaryStage.setX(x);
//                    primaryStage.setY(y);
//                }
                Double x = (Double)Math.random()*700;
                Double y = (Double)Math.random()*550;
                System.out.println("X = " + x);
                System.out.println("Y = " + y);
                primaryStage.setX(x);
                primaryStage.setY(y);
            }
        });

    }
}
