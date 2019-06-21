package fx.com;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Button button1  = new Button();
        button1.setText("Miko");

        button1.setLayoutX(130);
        button1.setLayoutY(110);

        button1.setPrefHeight(100);
        button1.setPrefWidth(150);

        button1.setFont(Font.font("sans-serif", 30));

//        button1.setTextFill(Paint.valueOf("#ff0000"));


//        Button button2  = new Button();
//        button2.setText("Miko");
//
//        button2.setLayoutX(130);
//        button2.setLayoutY(110);
//
//        button2.setPrefHeight(50);
//        button2.setPrefWidth(100);

        // #00000050  前6位是颜色(RGB) 第7,8位是透明度
//        BackgroundFill bgf = new BackgroundFill(Paint.valueOf("#8f8f8f50"), new CornerRadii(20), new Insets(5));
//        Background bg = new Background(bgf);
//        button1.setBackground(bg);
//
//        BorderStroke bos = new BorderStroke(Paint.valueOf("#000000"), BorderStrokeStyle.DOTTED, new CornerRadii(20), new BorderWidths(3));
//        Border bo = new Border(bos);
//        button1.setBorder(bo);

        button1.setStyle("-fx-background-color:#7CCD7C;"
                +"-fx-background-radius:20;"
                +"-fx-text-fill:#5CACEE"
        );

        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Button bu = (Button) event.getSource();
                System.out.println(bu.getText() + " Cute!!!");
            }
        });



        Group root = new Group();
//        root.getChildren().add(button2);
        root.getChildren().add(button1);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);

        primaryStage.setTitle("Miko is code AI?");
        primaryStage.setHeight(450);
        primaryStage.setWidth(600);
        primaryStage.show();
    }
}
