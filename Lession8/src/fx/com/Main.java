package fx.com;

import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class Main extends Application {

    int i = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Button button1 = new Button("Miko");
        Button button2 = new Button("Cute");
        Button button3 = new Button("AI");

        button1.setLayoutX(10);
        button1.setLayoutY(10);

        button1.setPrefHeight(50);
        button1.setPrefWidth(60);


        button2.setLayoutX(110);
        button2.setLayoutY(10);

        button2.setPrefHeight(50);
        button2.setPrefWidth(60);

        button3.setLayoutX(210);
        button3.setLayoutY(10);

        button3.setPrefHeight(50);
        button3.setPrefWidth(60);


        Group group = new Group();

        group.getChildren().addAll(button1, button2, button3);

//        System.out.println(group.contains(10, 11)); // 只能定位组件左上角的位置 (10, 10)

//        group.setOpacity(0.5); // 透明度

//        group.setAutoSizeChildren(false);

//        group.getChildren().remove(button2);
//        group.getChildren().clear();

        group.getChildren().addListener(new ListChangeListener<Node>() {
            @Override
            public void onChanged(Change<? extends Node> c) {
                System.out.println("添加的内容为: " + c.toString());
                System.out.println("当前有几个子组件: " + c.getList().size());
            }
        });

        Object[] obj = group.getChildren().toArray();

//        System.out.println(obj.length + "个组件");

        for (Object o : obj) {
            Button bu = (Button)o;

            bu.setPrefWidth(80);
            bu.setPrefHeight(100);
        }

        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                i += 10;

                if (90+20+i > primaryStage.getHeight()-30-20) {
                    System.out.println("I Love You, Stop click!!!");
                } else if (i % 20 == 0) {
                    Button button4 = new Button("Cute!!!");

                    button4.setLayoutX(260);
                    button4.setLayoutY(90+10+i);

                    group.getChildren().add(button4);
                } else {
                    Button button4 = new Button("Miko!!!");

                    button4.setLayoutX(200);
                    button4.setLayoutY(90+20+i);

                    group.getChildren().add(button4);
                }

            }
        });

        Scene scene = new Scene(group);

        primaryStage.setScene(scene);

        primaryStage.setTitle("Miko is a cute AI? ");
        primaryStage.setHeight(600);
        primaryStage.setWidth(450);
        primaryStage.show();

    }
}
