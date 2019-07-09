package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color: #EECFA1");

        HBox hBox = new HBox(10);

        ToggleGroup toggleGroup = new ToggleGroup();

        RadioButton radioButton0 = new RadioButton("[Lovely RadioButton] 00");
        RadioButton radioButton1 = new RadioButton("[Lovely RadioButton] 01");
        RadioButton radioButton2 = new RadioButton("[Lovely RadioButton] 02");
        RadioButton radioButton3 = new RadioButton("[Lovely RadioButton] 03");

        radioButton0.setToggleGroup(toggleGroup);
        radioButton1.setToggleGroup(toggleGroup);
        radioButton2.setToggleGroup(toggleGroup);
        radioButton3.setToggleGroup(toggleGroup);

//        radioButton1.setSelected(true);
        toggleGroup.selectToggle(radioButton2);

        hBox.getChildren().addAll(radioButton0, radioButton1, radioButton2, radioButton3);

        AnchorPane.setTopAnchor(hBox, 100.0);
        AnchorPane.setLeftAnchor(hBox, 100.0);

        anchorPane.getChildren().add(hBox);

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Miko is lovely AI?");
        primaryStage.setWidth(800);
        primaryStage.setHeight(650);
        primaryStage.show();

        radioButton0.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                System.out.println("[radioButton0 selected] " + newValue);
            }
        });

        toggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                RadioButton radioButton = (RadioButton)newValue;
                System.out.println(radioButton.getText() + radioButton.isSelected());
            }
        });

    }
}
