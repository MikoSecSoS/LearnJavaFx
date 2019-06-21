package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Cute Miko Study JavaFx");

        primaryStage.getIcons().add(new Image("./icon/favicon.ico"));

//        primaryStage.setIconified(true);
//        primaryStage.setMaximized(true);

        primaryStage.setWidth(500);
        primaryStage.setHeight(500);

//        primaryStage.setMaxWidth(800);
//        primaryStage.setMaxHeight(600);

//        primaryStage.setResizable(false);

//        primaryStage.setMinWidth(500);
//        primaryStage.setMinHeight(500);

//        System.out.println("Width: " + primaryStage.getWidth());
//        System.out.println("Height: " + primaryStage.getWidth());

        primaryStage.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("Height: " + newValue.doubleValue());
            }
        });

        primaryStage.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("Width: " + newValue.doubleValue());
            }
        });

        primaryStage.setFullScreen(true);

        primaryStage.setScene(new Scene(new Group()));

        primaryStage.show();


//        System.out.println("Width: " + primaryStage.getWidth());
//        System.out.println("Height: " + primaryStage.getWidth());

//        Thread.sleep(1000);

//        primaryStage.close();

    }
}
