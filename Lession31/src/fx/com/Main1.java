package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Iterator;
import java.util.function.Consumer;

public class Main1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color: #EECFA1");

        HBox hBox = new HBox(10);

        CheckBox checkBox0 = new CheckBox("[checkBox] 00");
        CheckBox checkBox1 = new CheckBox("[checkBox] 01");
        CheckBox checkBox2 = new CheckBox("[checkBox] 02");
        CheckBox checkBox3 = new CheckBox("[checkBox] 03");

        checkBox0.setSelected(true);

        checkBox1.setIndeterminate(true);

        checkBox2.setAllowIndeterminate(true);

        hBox.getChildren().addAll(checkBox0, checkBox1, checkBox2, checkBox3);

        AnchorPane.setTopAnchor(hBox, 100.0);
        AnchorPane.setLeftAnchor(hBox, 100.0);

        anchorPane.getChildren().add(hBox);

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Miko is lovely AI?");
        primaryStage.setWidth(800);
        primaryStage.setHeight(650);
        primaryStage.show();

        checkBox0.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                System.out.println(checkBox0.getText() + " -> " + newValue);
            }
        });

        anchorPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
//                Object[] objects =hBox.getChildren().toArray();
//                for (Object obj : objects) {
//                    CheckBox checkBox = (CheckBox)obj;
//
//                    System.out.println(checkBox.getText() + " -> " + checkBox.isSelected() + " => " + checkBox.isIndeterminate());
//                }

//                Iterator<Node> iterator = hBox.getChildren().iterator();
//                while (iterator.hasNext()) {
//                    CheckBox checkBox = (CheckBox)iterator.next();
//                    System.out.println(checkBox.getText() + " -> " + checkBox.isSelected() + " => " + checkBox.isIndeterminate());
//                }

//                hBox.getChildren().forEach(new Consumer<Node>() {
//                    @Override
//                    public void accept(Node node) {
//                    CheckBox checkBox = (CheckBox)node;
//                    System.out.println(checkBox.getText() + " -> " + checkBox.isSelected() + " => " + checkBox.isIndeterminate());
//                    }
//                });

                hBox.getChildren().forEach(item -> {
                    CheckBox checkBox = (CheckBox)item;
                    System.out.println(checkBox.getText() + " -> " + checkBox.isSelected() + " => " + checkBox.isIndeterminate());
                });

            }
        });

    }
}
