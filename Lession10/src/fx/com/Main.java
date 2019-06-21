package fx.com;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
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

        button1.setFont(Font.font(30));


        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Button bu = (Button) event.getSource();
                System.out.println("[button1的左键单击事件] " + bu.getText());
            }
        });

        button1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                System.out.println("[盯~] " + event.getButton().name());

                if (event.getClickCount() == 2 && event.getButton().name().equals(MouseButton.PRIMARY.name())) {
                    System.out.println("左键双击: " + event.getButton().name());
                } else if (event.getClickCount() > 2 && event.getButton().name().equals(MouseButton.PRIMARY.name())) {
                    System.out.println("左键多击(>2): " + event.getButton().name());
                }
            }
        });

        button1.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.println("[按下] " + event.getCode().getName());

                if (event.getCode().getName().equals(KeyCode.M.getName())) {
                    System.out.println("按下了M键盘!!! 您要输入iko了嘛!!!");
                }
            }
        });

//        button1.setOnKeyReleased(new EventHandler<KeyEvent>() {
//            @Override
//            public void handle(KeyEvent event) {
//                System.out.println("[释放] " + event.getCode().getName());
//            }
//        });


        Group root = new Group();
        root.getChildren().add(button1);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);

        primaryStage.setTitle("Miko is code AI?");
        primaryStage.setHeight(450);
        primaryStage.setWidth(600);
        primaryStage.show();
    }
}
