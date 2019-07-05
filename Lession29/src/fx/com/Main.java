package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.NodeOrientation;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
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

        Accordion accordion = new Accordion();

        TitledPane titledPane0 = new TitledPane("[titledPane - 00]", new Button("Lovely Button - 00"));


        TitledPane titledPane1 = new TitledPane();

        titledPane1.setText("[titledPane - 01]");
        titledPane1.setContent(new Button("Lovely Button - 01"));


        TitledPane titledPane2 = new TitledPane();
        titledPane2.setText("[titledPane - 02]");

        HBox hBox = new HBox();
        hBox.setStyle("-fx-background-color: #FAFABE");
        hBox.getChildren().addAll(new Button("Lovely Button - 02"), new Button("Lovely Button - 03"), new Button("Lovely Button - 04"));

        titledPane2.setContent(hBox);
        titledPane2.setGraphic(new Button("Cute!"));

        titledPane2.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);

        anchorPane.setTopAnchor(titledPane1, 180.0);
        anchorPane.setTopAnchor(titledPane2, 80.0);

//        titledPane0.setAnimated(false); // 展开关闭动画

//        titledPane0.setCollapsible(false); // 是否可以展开

        titledPane0.setExpanded(false); // 是否展开

        accordion.getPanes().addAll(titledPane0, titledPane1, titledPane2);

        anchorPane.getChildren().addAll(accordion);

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);

        primaryStage.setTitle("Miko is lovely AI?");
        primaryStage.setWidth(700);
        primaryStage.setHeight(550);

        primaryStage.show();

        titledPane0.expandedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                System.out.println(newValue);
            }
        });

        accordion.expandedPaneProperty().addListener(new ChangeListener<TitledPane>() {
            @Override
            public void changed(ObservableValue<? extends TitledPane> observable, TitledPane oldValue, TitledPane newValue) {
                if (newValue == null) {
                    System.out.println(oldValue.getText() + " Close");
                } else {
                    System.out.println(newValue.getText() + " Open");
                }
            }
        });

    }
}
