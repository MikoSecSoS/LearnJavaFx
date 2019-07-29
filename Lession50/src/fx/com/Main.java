package fx.com;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color: #0FFFFF");

        Button button = new Button("[Lovely Btn]");
//        button.setPrefWidth(100);
//        button.setPrefWidth(HBox.USE_COMPUTED_SIZE);
        button.setMaxWidth(Button.USE_PREF_SIZE);

        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(100);
        rectangle.setHeight(100);

        HBox hBox = new HBox();

        hBox.getChildren().addAll(button, rectangle);

        anchorPane.getChildren().addAll(hBox);

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Miko is lovely AI?");
        primaryStage.setWidth(800);
        primaryStage.setHeight(650);
        primaryStage.show();

//        System.out.println(button.isResizable());
//        System.out.println(rectangle.isResizable());
//
//        System.out.println(button.getPrefWidth());
//        System.out.println(button.getWidth());

        System.out.println(button.getHeight());

        System.out.println(button.prefHeight(-1));
        button.setWrapText(true);
        System.out.println(button.getContentBias());
    }
}
