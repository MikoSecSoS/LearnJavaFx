package fx.com;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Screen screen = Screen.getPrimary();

        double dpi = screen.getDpi();

        System.out.println("[DPI] " + dpi + "\n");

        Rectangle2D rec1 = screen.getBounds();

        Rectangle2D rec2 = screen.getVisualBounds();

        // bounds of this Screen.
        System.out.println(rec2.getMinX() + "    " + rec2.getMinY());
        System.out.println(rec2.getMaxX() + "    " + rec2.getMaxY());

        System.out.println(rec1.getWidth() + "    " + rec1.getHeight());

        System.out.println();

        // visual bounds of this Screen.
        System.out.println(rec2.getMinX() + "    " + rec2.getMinY());
        System.out.println(rec2.getMaxX() + "    " + rec2.getMaxY());

        System.out.println(rec2.getWidth() + "    " + rec2.getHeight());

        primaryStage.show();

        Platform.exit();
    }
}
