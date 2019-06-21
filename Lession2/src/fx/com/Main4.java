package fx.com;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main4 extends Application {
    public static void main(String[] args) {
        System.out.println("main run...: " + Thread.currentThread().getName());
        launch(args);
    }

    @Override
    public void init() throws Exception {
        System.out.println("init run...: " + Thread.currentThread().getName());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("start run...: " + Thread.currentThread().getName());

        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        System.out.println("stop run...: " + Thread.currentThread().getName());
    }
}
