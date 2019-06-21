package fx.com;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {

                System.out.println("[run Method Tread Name]: " + Thread.currentThread().getName());

                System.out.println("Miko cute");

                int i = 1;

                while (i <= 10) {

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("i = " + i);

                    i += 1;
                }

            }
        });

        System.out.println("[start Method Tread Name]: " + Thread.currentThread().getName());
        System.out.println("AI cute");

    }
}
