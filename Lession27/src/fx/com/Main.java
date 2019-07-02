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
        Menu menu3 = new Menu("menu3");

        SeparatorMenuItem separatorMenuItem0 = new SeparatorMenuItem();
        SeparatorMenuItem separatorMenuItem1 = new SeparatorMenuItem();

        MenuItem menuItem0 = new MenuItem("Cute - 00");

        menuItem0.setAccelerator(KeyCombination.valueOf("ctrl+i"));

        MenuItem menuItem1 = new MenuItem("Cute - 01");
        MenuItem menuItem2 = new MenuItem("Cute - 02");
        MenuItem menuItem3 = new MenuItem("Cute - 03");

        Menu menu = new Menu("qwq -> QAQ");
        MenuItem menuItem4 = new MenuItem("Cute - 04");
        MenuItem menuItem5 = new MenuItem("Cute - 05");

        menu.getItems().addAll(menuItem4, menuItem5);

        menuItem0.setDisable(true);
//        menu0.setDisable(true);

        menuItem2.setVisible(false);

        ToggleGroup toggleGroup = new ToggleGroup();
        RadioMenuItem radioMenuItem0 = new RadioMenuItem("[radioMenuItem] - 00");
        RadioMenuItem radioMenuItem1 = new RadioMenuItem("[radioMenuItem] - 01");
        RadioMenuItem radioMenuItem2 = new RadioMenuItem("[radioMenuItem] - 02");
        radioMenuItem0.setToggleGroup(toggleGroup);
        radioMenuItem1.setToggleGroup(toggleGroup);
        radioMenuItem2.setToggleGroup(toggleGroup);

        radioMenuItem1.setSelected(true);

        CheckMenuItem checkMenuItem0 = new CheckMenuItem("[checkMenuItem] -- 00");
        CheckMenuItem checkMenuItem1 = new CheckMenuItem("[checkMenuItem] -- 01");
        CheckMenuItem checkMenuItem2 = new CheckMenuItem("[checkMenuItem] -- 02");

        menu0.getItems().addAll(menuItem0, separatorMenuItem0, menuItem1, separatorMenuItem1, menuItem2, menuItem3, menu);

        menu1.getItems().addAll(radioMenuItem0, radioMenuItem1, radioMenuItem2);

        menu2.getItems().addAll(checkMenuItem0, checkMenuItem1, checkMenuItem2);

        menuBar.getMenus().addAll(menu0, menu1, menu2, menu3);

        menu0.setOnHidden(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                System.out.println("[menu0.setOnHidden]");
            }
        });

        menu0.setOnShowing(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                System.out.println("[menu0.setOnShowing]");
            }
        });

        menuItem0.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("[menuItem0.setOnAction] " + menuItem0.getText());
            }
        });

        menuItem1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("[menuItem1.setOnAction] " + menuItem0.getText());
            }
        });

        anchorPane.getChildren().add(menuBar);

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Miko is lovely AI?");
        primaryStage.setWidth(700);
        primaryStage.setHeight(550);
        primaryStage.show();

        menuBar.setPrefWidth(primaryStage.getWidth());

        radioMenuItem0.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
//                RadioMenuItem radioMenuItem = (RadioMenuItem)event.getSource();
//                System.out.println(radioMenuItem.isSelected());
                System.out.println("[radioMenuItem0 Selected]" + radioMenuItem0.isSelected());
                System.out.println("[radioMenuItem1 Selected]" + radioMenuItem1.isSelected());
                System.out.println("[radioMenuItem2 Selected]" + radioMenuItem2.isSelected());
            }
        });

        radioMenuItem1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
//                RadioMenuItem radioMenuItem = (RadioMenuItem)event.getSource();
//                System.out.println(radioMenuItem.isSelected());
                System.out.println("[radioMenuItem0 Selected]" + radioMenuItem0.isSelected());
                System.out.println("[radioMenuItem1 Selected]" + radioMenuItem1.isSelected());
                System.out.println("[radioMenuItem2 Selected]" + radioMenuItem2.isSelected());
            }
        });

        radioMenuItem2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
//                RadioMenuItem radioMenuItem = (RadioMenuItem)event.getSource();
//                System.out.println(radioMenuItem.isSelected());
                System.out.println("[radioMenuItem0 Selected]" + radioMenuItem0.isSelected());
                System.out.println("[radioMenuItem1 Selected]" + radioMenuItem1.isSelected());
                System.out.println("[radioMenuItem2 Selected]" + radioMenuItem2.isSelected());
            }
        });

        checkMenuItem0.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("[checkMenuItem0 Selected]" + checkMenuItem0.isSelected());
                System.out.println("[checkMenuItem1 Selected]" + checkMenuItem1.isSelected());
                System.out.println("[checkMenuItem2 Selected]" + checkMenuItem2.isSelected());
            }
        });

        checkMenuItem1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("[checkMenuItem0 Selected]" + checkMenuItem0.isSelected());
                System.out.println("[checkMenuItem1 Selected]" + checkMenuItem1.isSelected());
                System.out.println("[checkMenuItem2 Selected]" + checkMenuItem2.isSelected());
            }
        });

        checkMenuItem2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("[checkMenuItem0 Selected]" + checkMenuItem0.isSelected());
                System.out.println("[checkMenuItem1 Selected]" + checkMenuItem1.isSelected());
                System.out.println("[checkMenuItem2 Selected]" + checkMenuItem2.isSelected());
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
