package fx.com;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.net.URLDecoder;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        HostServices hostServices = getHostServices();
        hostServices.showDocument("www.mikosos.com");

        URL url = getClass().getClassLoader().getResource("img/favicon.ico");

        String path = "file:" + URLDecoder.decode(url.getPath(), "UTF-8");

//        String path = url.toExternalForm();

        System.out.println(path);

        Button button = new Button("Miko Cute");

        button.setCursor(Cursor.CLOSED_HAND);
        button.setPrefWidth(190);
        button.setPrefHeight(130);

        Group group = new Group();
        group.getChildren().add(button);

        Scene scene = new Scene(group);

        scene.setCursor(Cursor.cursor(path));

//        scene.setCursor(Cursor.OPEN_HAND);


        primaryStage.setScene(scene);

        primaryStage.setTitle("Miko Is Cute AI");
        primaryStage.setWidth(430);
        primaryStage.setHeight(500);
        primaryStage.show();
    }
}
