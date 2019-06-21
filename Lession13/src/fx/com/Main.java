package fx.com;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Button button1 = new Button("Lovely Miko.");
        button1.setLayoutX(50);
        button1.setLayoutY(50);

        Button button2 = new Button("Lovely AI.");

        Button button3 = new Button("Lovely Miko!!!");

        Button button4 = new Button("Lovely AI!!!");

        AnchorPane anchorPane = new AnchorPane();

        Group group1 = new Group();
        Group group2 = new Group();

        group1.getChildren().addAll(button1, button2);

        group2.getChildren().addAll(button3, button4);

//        anchorPane.setPadding(new Insets(10)); // 内边距

//        anchorPane.setTopAnchor(button1, 0.0);  // 自适应
//        anchorPane.setLeftAnchor(button1, 0.0);
//        anchorPane.setRightAnchor(button1, 10.0);
//        anchorPane.setBottomAnchor(button1, 10.0);

//        anchorPane.setTopAnchor(button2, 100.0);
//        anchorPane.setLeftAnchor(button2, 100.0);

//        button1.setLayoutX(100); // 使用anchorPane setTopAnchor后此行代码无效
//        button1.setLayoutY(60);

        anchorPane.setTopAnchor(group1, 100.0);
        anchorPane.setLeftAnchor(group1, 100.0);

        anchorPane.setTopAnchor(group2, 200.0);
        anchorPane.setLeftAnchor(group2, 200.0);

        anchorPane.getChildren().addAll(group1, group2); // , button2);

        anchorPane.setStyle("-fx-background-color: green");

        anchorPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Cute~ >_<");
            }
        });

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Miko is a lovely AI?");
        primaryStage.setHeight(500);
        primaryStage.setWidth(700);

        primaryStage.show();
    }
}
