package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main3 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color: #EECFA1");

        Button button = new Button("Lovely Button");

        ContextMenu contextMenu = new ContextMenu();
        MenuItem menuItem0 = new MenuItem("Cute - 00");
        MenuItem menuItem1 = new MenuItem("Cute - 01");
        MenuItem menuItem2 = new MenuItem("Cute - 02");
        contextMenu.getItems().addAll(menuItem0, menuItem1, menuItem2);


        anchorPane.getChildren().add(button);

        button.setContextMenu(contextMenu);

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Miko is lovely AI?");
        primaryStage.setWidth(700);
        primaryStage.setHeight(550);
        primaryStage.show();

        button.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
            @Override
            public void handle(ContextMenuEvent event) {
                Button button1 = (Button)event.getSource();

                System.out.println("[setContextMenu] " + button1.getText());
            }
        });

    }
}
