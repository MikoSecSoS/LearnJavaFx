package fx.com;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    static boolean isManaged = false;
    static boolean isVisible = false;
    static int opacityValue = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Button button1 = new Button("Button1");
        Button button2 = new Button("Button2");
        Button button3 = new Button("Button3");
        Button button4 = new Button("Button4");

        Button button5 = new Button("button3.setManaged(false);");
        Button button6 = new Button("button3.setVisible(false);");
        Button button7 = new Button("button3.setOpacity(0);");

//        button3.setManaged(false);
//        button3.setVisible(false);
//        button3.setOpacity(0);

        AnchorPane anchorPane1 = new AnchorPane();

        anchorPane1.setStyle("-fx-background-color: #FFFFFF");

        HBox hBox = new HBox();
        hBox.getChildren().addAll(button1, button2, button3, button4);
        hBox.setPadding(new Insets(20));
        hBox.setSpacing(10);

        VBox vBox = new VBox();

        vBox.setSpacing(10);
        vBox.getChildren().addAll(button5, button6, button7);

        anchorPane1.setTopAnchor(vBox, 100.0);
        anchorPane1.setLeftAnchor(vBox, 20.0);

        anchorPane1.getChildren().addAll(hBox, vBox);

        Scene scene = new Scene(anchorPane1);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Miko is lovely AI?");
        primaryStage.setWidth(600);
        primaryStage.setHeight(550);
        primaryStage.show();

        button5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                button3.setManaged(isManaged);
                new Print(hBox);

                if (isManaged == true) {
                    isManaged = false;
                    button5.setText("button3.setManaged(" + isManaged + ")");
                } else {
                    isManaged = true;
                    button5.setText("button3.setManaged(" + isManaged + ")");
                }
            }
        });

        button6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                button3.setVisible(isVisible);
                new Print(hBox);

                if (isVisible == true) {
                    isVisible = false;
                    button6.setText("button3.isVisible(" + isVisible + ")");
                } else {
                    isVisible = true;
                    button6.setText("button3.isVisible(" + isVisible + ")");
                }
            }
        });

        button7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                button3.setOpacity(opacityValue);
                new Print(hBox);
                if (opacityValue == 0) {
                    opacityValue = 1;

                    button7.setText("button3.setOpacity(" + opacityValue + ")");
                } else {
                    opacityValue = 0;
                    button7.setText("button3.setOpacity(" + opacityValue + ")");
                }

            }
        });
    }
}


class Print {
    Print(HBox hBox) {
        System.out.println("[当前Hbox里子组件数量] " + hBox.getChildren().size());
    }
}
