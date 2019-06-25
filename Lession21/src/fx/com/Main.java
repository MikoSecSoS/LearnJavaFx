package fx.com;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Button button0 = new Button("Lovely Button-00");
        button0.setPrefHeight(100);
        Button button1 = new Button("Lovely Button-01");
        Button button2 = new Button("Lovely Button-02");
        Button button3 = new Button("Lovely Button-03");
        Button button4 = new Button("Lovely Button-04");
        Button button5 = new Button("Lovely Button-05");
        Button button6 = new Button("Lovely Button-06");
        Button button7 = new Button("Lovely Button-07");

        TilePane tilePane = new TilePane();
        tilePane.setStyle("-fx-background-color: #EECFA1");

        tilePane.setHgap(10);
        tilePane.setVgap(10);

        tilePane.setPadding(new Insets(10));
//        tilePane.setAlignment(Pos.BOTTOM_CENTER);

        tilePane.setAlignment(button1, Pos.BOTTOM_LEFT);

        tilePane.setMargin(button0, new Insets(10));

        tilePane.setOrientation(Orientation.VERTICAL);

        tilePane.getChildren().addAll(button0, button1, button2, button3, button4, button5, button6, button7);

        Scene scene = new Scene(tilePane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Miko is lovely AI?");
        primaryStage.setWidth(700);
        primaryStage.setHeight(550);
        primaryStage.show();
    }
}
