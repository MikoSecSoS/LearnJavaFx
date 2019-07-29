package fx.com;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main3 extends Application {

    int i = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color: #0FFFFF");

        Button button = new Button("[Lovely Btn 00]");

        button.setEffect(new DropShadow());

        button.setRotate(20);

        anchorPane.setTopAnchor(button, 100.0);
        anchorPane.setLeftAnchor(button, 100.0);

        anchorPane.getChildren().addAll(button);

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Miko is lovely AI?");
        primaryStage.setWidth(800);
        primaryStage.setHeight(650);
        primaryStage.show();

        button.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().getName().equals(KeyCode.A.getName())) {
                    button.setRotate(i-=5);
                }
                if (event.getCode().getName().equals(KeyCode.D.getName())) {
                    button.setRotate(i+=5);
                }
            }
        });

        System.out.println(button.getLayoutBounds());

        System.out.println(button.getBoundsInLocal());

        System.out.println(button.getBoundsInParent());

    }
}