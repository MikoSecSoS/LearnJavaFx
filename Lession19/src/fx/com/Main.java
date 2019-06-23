package fx.com;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Button button0 = new Button("Button AI-00");
        Button button1 = new Button("Button AI-01");
        Button button2 = new Button("Button AI-02");
        Button button3 = new Button("Button AI-03");
        Button button4 = new Button("Button AI-04");

        StackPane stackPane = new StackPane();
        stackPane.setStyle("-fx-background-color: #EE6AAF");

        stackPane.setPadding(new Insets(10));

        stackPane.setAlignment(Pos.BASELINE_LEFT);

        stackPane.setMargin(button0, new Insets(100));

        stackPane.getChildren().addAll(button0, button1, button2, button3, button4);

//        stackPane.getChildren().forEach(new Consumer<Node>() {
//            @Override
//            public void accept(Node node) {
//                Button button = (Button)node;
//                System.out.println(button.getText());
//            }
//        });

        stackPane.getChildren().forEach((item) -> {
            Button button = (Button)item;
            System.out.println(button.getText());
        });

        Scene scene = new Scene(stackPane);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Miko is lovely AI?");
        primaryStage.setWidth(700);
        primaryStage.setHeight(550);
        primaryStage.show();
    }
}
