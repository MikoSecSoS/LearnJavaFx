package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

//        primaryStage.setOpacity(0.7);

//        primaryStage.setAlwaysOnTop(true);

        primaryStage.setWidth(450);
        primaryStage.setHeight(300);

        primaryStage.setX(100);
        primaryStage.setY(100);

        primaryStage.xProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("X: " + newValue);
            }
        });

        primaryStage.yProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("Y: " + newValue);
            }
        });

        primaryStage.show();
    }
}
