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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Button button = new Button("[Miko]");

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color: #0FFFFF");

        VBox vBox = new VBox(10);

        for (int i = 0; i < 10; i++) {
            vBox.getChildren().add(new Button("[Lovely Button] " + i));
        }

        ScrollBar scrollBar = new ScrollBar();
        scrollBar.setOrientation(Orientation.VERTICAL);

        scrollBar.setVisibleAmount(10);
//        scrollBar.setValue(20);

        scrollBar.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println(newValue);
                vBox.setLayoutY(-newValue.doubleValue());
            }
        });

        anchorPane.setLeftAnchor(scrollBar, 115.0);
        anchorPane.setLeftAnchor(button, 200.0);

        anchorPane.getChildren().addAll(vBox, scrollBar, button);

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Miko is lovely AI?");
        primaryStage.setWidth(800);
        primaryStage.setHeight(650);
        primaryStage.show();

        scrollBar.setPrefHeight(vBox.getHeight());
        scrollBar.setPrefWidth(vBox.getWidth());

        scrollBar.setMax(vBox.getHeight());

        scrollBar.setUnitIncrement(20);
        scrollBar.setBlockIncrement(50);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                scrollBar.increment();
//                scrollBar.decrement();
            }
        });
    }
}