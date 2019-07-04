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

public class Main1 extends Application {

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

        MenuButton menuButton = new MenuButton("[menuButton]");

        anchorPane.setTopAnchor(menuButton, 200.0);

        MenuItem menuItem3 = new MenuItem("Cute - 03");
        MenuItem menuItem4 = new MenuItem("Cute - 04");
        MenuItem menuItem5 = new MenuItem("Cute - 05");

        menuItem3.setAccelerator(KeyCombination.valueOf("ctrl+k"));

        CustomMenuItem customMenuItem = new CustomMenuItem();
        HBox hBox = new HBox();
        hBox.setPrefWidth(150);
        hBox.setPrefHeight(150);
        hBox.setStyle("-fx-background-color: #AFAFBB");
        hBox.getChildren().addAll(new Button("qwq"), new Button("QAQ"), new Button("=w="));
        customMenuItem.setContent(hBox);

        menuButton.setMaxWidth(200);
        menuButton.setMaxHeight(200);

        menuButton.getItems().addAll(menuItem3, menuItem4, menuItem5);

        menuBar.getMenus().addAll(menu0, menu1, menu2);

        menu0.getItems().addAll(menuItem0, menuItem1, menuItem2, customMenuItem);

        anchorPane.getChildren().addAll(menuBar, menuButton);

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Miko is lovely AI?");
        primaryStage.setWidth(700);
        primaryStage.setHeight(550);
        primaryStage.show();

        menuBar.setPrefWidth(primaryStage.getWidth());

        menuItem3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                menuButton.setText(">__<");
            }
        });

        menuItem3.setOnMenuValidation(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                System.out.println("[setOnMenuValidation]" + ((MenuItem)event.getSource()).getText());
            }
        });

        anchorPane.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                menuBar.setPrefWidth(newValue.doubleValue());
            }
        });

    }
}
