package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    ScheduledService<Double> scheduledService;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color: #0FFFFF");

        ProgressIndicator progressIndicator = new ProgressIndicator(0);
        progressIndicator.setPrefWidth(100);
        progressIndicator.setPrefHeight(100);
//        progressIndicator.setProgress(ProgressIndicator.INDETERMINATE_PROGRESS);

        ProgressBar progressBar = new ProgressBar(0);
        progressBar.setPrefWidth(600);
        progressBar.setPrefHeight(20);

//        progressBar.setProgress(ProgressIndicator.INDETERMINATE_PROGRESS);

//        progressBar.setProgress(0.2);

        anchorPane.setTopAnchor(progressBar, 200.0);
        anchorPane.setLeftAnchor(progressBar, 100.0);

        anchorPane.getChildren().addAll(progressBar, progressIndicator);

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Miko is lovely AI?");
        primaryStage.setWidth(800);
        primaryStage.setHeight(650);
        primaryStage.show();

        progressBar.progressProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (newValue.doubleValue() >= 1 && anchorPane.getChildren().size() < 500){
                    Button button = new Button("[Cute]");
                    anchorPane.setTopAnchor(button, (Double) (Math.random() * 650));
                    anchorPane.setLeftAnchor(button, (Double) (Math.random() * 770));
                    anchorPane.getChildren().add(button);
                    System.out.println("[anchorPane.getChildren().add(button)] size:" + anchorPane.getChildren().size());
                }
            }
        });

        scheduledService = new ScheduledService<Double>() {
            double i = progressBar.getProgress();
            @Override
            protected Task<Double> createTask() {
                Task<Double> task = new Task<Double>() {
                    @Override
                    protected Double call() throws Exception {
                        return i += 0.001;
                    }

                    @Override
                    protected void updateValue(Double value) {
                        progressBar.setProgress(value);
                        progressIndicator.setProgress(value);
                        if (value >= 1) {
//                            scheduledService.cancel();
//                            System.out.println("[scheduledService] cancel()");
                            progressBar.setProgress(0);
                            progressIndicator.setProgress(0);
                            i = 0;
                            System.out.println("[progressBar.setProgress(0)]");
                        }
                    }
                };
                return task;
            }
        };

        scheduledService.setDelay(Duration.millis(0));
        scheduledService.setPeriod(Duration.millis(5));
        scheduledService.start();

    }
}
