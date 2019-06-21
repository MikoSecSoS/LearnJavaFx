package fx.com;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Button button1 = new Button("button1");

        Button button2 = new Button("button2");

        Button button3 = new Button("button3");

        Button button4 = new Button("button4");

        Button button5 = new Button("button5");

        AnchorPane anchorPane1 = new AnchorPane();

        anchorPane1.setStyle("-fx-background-color: #AEEEEE");

        HBox hBox = new HBox(); // VBox 纵向排列
        hBox.setPrefWidth(300);
        hBox.setPrefHeight(300);

        hBox.setPadding(new Insets(10)); // 内边距

        hBox.setSpacing(10); // 组件与组件距离

        hBox.setMargin(button1, new Insets(10));

        hBox.setAlignment(Pos.BOTTOM_CENTER);

        hBox.getChildren().addAll(button1, button2, button3);// , button4, button5);

        hBox.setStyle("-fx-background-color: #E066FF");

        anchorPane1.getChildren().add(hBox);

        Scene scene = new Scene(anchorPane1);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Miko is a lovely AI?");
        primaryStage.setWidth(600);
        primaryStage.setHeight(550);
        primaryStage.show();
    }
}
