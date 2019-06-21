package fx.com;

import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main3 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage s1 = new Stage();
        s1.setTitle("s1");

        Stage s2 = new Stage();
        s2.setTitle("s2");

        s2.initOwner(s1);
        s2.initModality(Modality.WINDOW_MODAL);

        Stage s3 = new Stage();
        s3.setTitle("s3");


        s1.show();
        s2.show();
        s3.show();
    }
}
