package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color: #EECFA1");

        MenuBar menuBar = new MenuBar();

        Menu menu0 = new Menu("menu0");
        Menu menu1 = new Menu("menu1");
        Menu menu2 = new Menu("menu2");

        MenuItem menuItem0 = new MenuItem("Cute - 00");
        MenuItem menuItem1 = new MenuItem("Cute - 01");
        MenuItem menuItem2 = new MenuItem("Cute - 02");

        CustomMenuItem customMenuItem0 = new CustomMenuItem();
        Button button = new Button("Lovely Button");
        customMenuItem0.setContent(button);

        CustomMenuItem customMenuItem1 = new CustomMenuItem();
        ProgressBar progressBar = new ProgressBar(0.5);
        customMenuItem1.setContent(progressBar);

        CustomMenuItem customMenuItem2 = new CustomMenuItem();
        HBox hBox = new HBox();
        hBox.setPrefWidth(150);
        hBox.setPrefHeight(150);
        hBox.setStyle("-fx-background-color: #AFAFBB");
        hBox.getChildren().addAll(new Button("qwq"), new Button("QAQ"), new Button("=w="));
        customMenuItem2.setContent(hBox);

        menuBar.getMenus().addAll(menu0, menu1, menu2);

        menu0.getItems().addAll(menuItem0, menuItem1, menuItem2, customMenuItem0, customMenuItem1, customMenuItem2);

        anchorPane.getChildren().add(menuBar);

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Miko is lovely AI?");
        primaryStage.setWidth(700);
        primaryStage.setHeight(550);
        primaryStage.show();

        menuBar.setPrefWidth(primaryStage.getWidth());

        anchorPane.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                menuBar.setPrefWidth(newValue.doubleValue());
            }
        });

    }
}
