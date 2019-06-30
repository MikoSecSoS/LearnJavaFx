package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.lang.reflect.Array;

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

        MenuItem menuItem0 = new MenuItem("Cute - 00", new ImageView("img/favicon.ico"));
//        menuItem0.setGraphic(new ImageView("img/favicon.ico"));

        menuItem0.setAccelerator(KeyCombination.valueOf("ctrl+i"));

        MenuItem menuItem1 = new MenuItem("Cute - 01");
        MenuItem menuItem2 = new MenuItem("Cute - 02");
        MenuItem menuItem3 = new MenuItem("Cute - 03");
        MenuItem menuItem4 = new MenuItem("Cute - 04");

        menu0.getItems().addAll(menuItem0, menuItem1, menuItem2);
        menu1.getItems().addAll(menuItem3, menuItem4);

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

        anchorPane.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                menuBar.setPrefWidth(newValue.doubleValue());
            }
        });

    }
}
