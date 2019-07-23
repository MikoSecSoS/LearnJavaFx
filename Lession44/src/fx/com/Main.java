package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.time.LocalDate;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Group group = new Group();

        Pagination pagination = new Pagination();
        pagination.setStyle("-fx-background-color: #FFFF00");
        pagination.setPrefWidth(440);
        pagination.setPrefHeight(300);

        pagination.setLayoutX(100);
        pagination.setLayoutY(100);

        pagination.setPageCount(20);

        pagination.setMaxPageIndicatorCount(5);

//        pagination.setPageCount(Pagination.INDETERMINATE); // 不确定页(可以无限翻下去qwq)

        pagination.setCurrentPageIndex(2); // 默认选择某某页

//        pagination.getStyleClass().add(Pagination.STYLE_CLASS_BULLET);

        pagination.setPageFactory(new Callback<Integer, Node>() {
            @Override
            public Node call(Integer param) {
                System.out.println("[Page] " + param);

                if (param == 0) {
                    HBox hBox = new HBox();
                    ColorPicker colorPicker = new ColorPicker();
                    hBox.getChildren().addAll(colorPicker);

                    colorPicker.valueProperty().addListener(new ChangeListener<Color>() {
                        @Override
                        public void changed(ObservableValue<? extends Color> observable, Color oldValue, Color newValue) {
                            hBox.setStyle("-fx-background-color: #" + newValue.toString().substring(2));
                        }
                    });
                    return hBox;
                } else if (param == 1) {
                    HBox hBox = new HBox();
                    DatePicker datePicker = new DatePicker();
                    Label label = new Label();
                    hBox.getChildren().addAll(datePicker, label);

                    datePicker.valueProperty().addListener(new ChangeListener<LocalDate>() {
                        @Override
                        public void changed(ObservableValue<? extends LocalDate> observable, LocalDate oldValue, LocalDate newValue) {
                            label.setText(newValue.toString());
                        }
                    });

                    return hBox;
                }

                return new Button("QwQ");
            }
        });

        group.getChildren().addAll(pagination);

        Scene scene = new Scene(group);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Miko is lovely AI?");
        primaryStage.setWidth(800);
        primaryStage.setHeight(650);
        primaryStage.show();

        pagination.currentPageIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("[currentPageIndexProperty] " + newValue);
            }
        });
    }
}
