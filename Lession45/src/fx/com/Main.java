package fx.com;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.StringConverter;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color: #0FFFFF");

        Slider slider = new Slider(0, 100, 0);
        slider.setPrefWidth(650);
//        slider.setPrefHeight(500);

        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
//        slider.setMajorTickUnit(10);
//        slider.setValue(50);

//        slider.setOrientation(Orientation.VERTICAL);

        My my = new My(slider);
        my.setDelay(Duration.millis(0));
        my.setPeriod(Duration.millis(10));
        my.start();

        my.valueProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
                if (newValue != null) {
                    System.out.println("[" + Thread.currentThread().getName() + "]" + newValue);
                    slider.setValue(newValue);
                }
            }
        });

        slider.setLabelFormatter(new StringConverter<Double>() {
            @Override
            public String toString(Double object) {
                if (object < 50) {
                    return "帅气!";
                } else if (object > 50) {
                    return "可爱!";
                }
                return "帅气又可爱";
            }

            @Override
            public Double fromString(String string) {
                return null;
            }
        });

        anchorPane.setTopAnchor(slider, 100.0);
        anchorPane.setLeftAnchor(slider, 100.0);
        anchorPane.getChildren().addAll(slider);

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Miko is lovely AI?");
        primaryStage.setWidth(800);
        primaryStage.setHeight(650);
        primaryStage.show();

//        slider.valueProperty().addListener(new ChangeListener<Number>() {
//            @Override
//            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
//                System.out.println("[valueProperty] " + newValue);
//            }
//        });
//
//        slider.valueChangingProperty().addListener(new ChangeListener<Boolean>() {
//            @Override
//            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
//                System.out.println("[valueChangingProperty] " + newValue);
//            }
//        });

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i <= 100; i++) {
//                    int t = i;
//                    Platform.runLater(new Runnable() {
//                        @Override
//                        public void run() {
//                            slider.setValue(t);
//                            System.out.println(Thread.currentThread().getName());
//                        }
//                    });
//
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();
    }
}

class My extends ScheduledService<Integer> {

    int i = 0;

    Slider slider;

    public My(Slider slider) {
        this.slider = slider;
    }

    @Override
    protected Task<Integer> createTask() {
        Task task = new Task<Integer>() {
            @Override
            protected Integer call() throws Exception {
                return i += 1;
            }

//            @Override
//            protected void updateValue(Integer value) {
//                super.updateValue(value);
//                slider.setValue(value);
//                if (i == 100) {
//                    this.cancel();
//                }
//            }
        };
        return task;
    }
}