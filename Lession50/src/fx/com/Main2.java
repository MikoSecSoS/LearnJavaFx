package fx.com;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main2 extends Application {

    double x = 0;
    double y = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color: #0FFFFF");

        Button button = new Button("[Lovely Btn 00]");
        Button button1 = new Button("[Lovely Btn 01]");


        anchorPane.setTopAnchor(button, 100.0);
        anchorPane.setLeftAnchor(button, 100.0);

        anchorPane.getChildren().addAll(button, button1);

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Miko is lovely AI?");
        primaryStage.setWidth(800);
        primaryStage.setHeight(650);
        primaryStage.show();

        Bounds bounds = button1.getLayoutBounds();

        Point2D point2D = button1.localToParent(bounds.getMinX(), bounds.getMinY());
        Point2D point2D1 = button1.localToParent(bounds.getMaxX(), bounds.getMaxY());

        System.out.println(point2D);
        System.out.println(point2D1);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

            Bounds bounds = button.getLayoutBounds();

            Point2D point2D2 = null;
            Point2D point2D3 = null;

            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().getName().equals(KeyCode.D.getName())) {
                    x+=10;

                    button.setLayoutX(x);

                    point2D2 = button.localToParent(bounds.getMinX(), bounds.getMinY());
                    point2D3 = button.localToParent(bounds.getMaxX(), bounds.getMaxY());
                }

                if (event.getCode().getName().equals(KeyCode.S.getName())) {
                    y+=10;

                    button.setLayoutY(y);

                    point2D2 = button.localToParent(bounds.getMinX(), bounds.getMinY());
                    point2D3 = button.localToParent(bounds.getMaxX(), bounds.getMaxY());
                }

                if (event.getCode().getName().equals(KeyCode.A.getName())) {
                    x-=10;

                    button.setLayoutX(x);

                    point2D2 = button.localToParent(bounds.getMinX(), bounds.getMinY());
                    point2D3 = button.localToParent(bounds.getMaxX(), bounds.getMaxY());
                }

                if (event.getCode().getName().equals(KeyCode.W.getName())) {
                    y-=10;

                    button.setLayoutY(y);

                    point2D2 = button.localToParent(bounds.getMinX(), bounds.getMinY());
                    point2D3 = button.localToParent(bounds.getMaxX(), bounds.getMaxY());
                }

                if (point2D3 == null) {
                    return;
                }

                if (point2D2.getX() >= point2D.getX() && point2D3.getY() > point2D2.getY()) {
                    if (point2D3.getX() <= point2D1.getX() && point2D3.getY() <= point2D1.getY()) {
                        System.out.println("Boom!!");
                        System.out.println(point2D3);

                        return;
                    }
                }

                System.out.println("Not Boom~");
            }
        });

    }
}
