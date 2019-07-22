package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.time.LocalDate;

public class Main1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {


        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color: #EECFA1");

        DatePicker datePicker = new DatePicker();

        datePicker.setEditable(false);

        datePicker.setDayCellFactory(new Callback<DatePicker, DateCell>() {
            @Override
            public DateCell call(DatePicker param) {
                DateCell dateCell = new DateCell() {
                    @Override
                    public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);

                        this.setGraphic(new Label("=>"));
                    }
                };
                return dateCell;
            }
        });

        anchorPane.getChildren().addAll(datePicker);

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Miko is lovely AI?");
        primaryStage.setWidth(800);
        primaryStage.setHeight(650);
        primaryStage.show();

        datePicker.valueProperty().addListener(new ChangeListener<LocalDate>() {
            @Override
            public void changed(ObservableValue<? extends LocalDate> observable, LocalDate oldValue, LocalDate newValue) {
                int year = newValue.getYear();
                int month = newValue.getMonthValue();
                int day = newValue.getDayOfMonth();
                int week = newValue.getDayOfWeek().getValue();
                int number = newValue.getDayOfYear();
                System.out.println(year +"年" + month + "月" + day + "日  " + "星期" + week + " -- " + "今天是今年的第" + number + "天");
            }
        });

    }
}