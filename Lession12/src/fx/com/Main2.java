package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main2 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Button button1 = new Button("Lovely Miko.");
        Button button2 = new Button("Lovely AI.");
        Button button3 = new Button("Lovely Miko!!!");
        Button button4 = new Button("Lovely AI!!!");

        AnchorPane anchorPane1 = new AnchorPane();

        AnchorPane anchorPane2 = new AnchorPane();

        anchorPane2.setStyle("-fx-background-color: blue");

        anchorPane1.setStyle("-fx-background-color: green");

        anchorPane2.getChildren().add(button1);
        anchorPane2.setRightAnchor(button1, 0.0);
        anchorPane2.setBottomAnchor(button1, 0.0);

        anchorPane1.getChildren().add(anchorPane2);

        Scene scene = new Scene(anchorPane1);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Miko is a lovely AI?");
        primaryStage.setHeight(500);
        primaryStage.setWidth(700);
        primaryStage.show();

//        anchorPane1.setManaged(false);

//        anchorPane1.setVisible(true);

//        anchorPane1.setOpacity(1);

        anchorPane1.setTopAnchor(anchorPane2, 0.0);
        anchorPane1.setLeftAnchor(anchorPane2, 0.0);
        anchorPane1.setRightAnchor(anchorPane2, primaryStage.getWidth() / 2);
        anchorPane1.setBottomAnchor(anchorPane2, primaryStage.getHeight() / 2);

        primaryStage.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                anchorPane1.setRightAnchor(anchorPane2, anchorPane1.getWidth() / 2);
            }
        });

        primaryStage.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                anchorPane1.setBottomAnchor(anchorPane2, anchorPane1.getHeight() / 2);
            }
        });

    }
}
