package fx.com;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        VBox vBox = new VBox();

        Hyperlink hyperlink = new Hyperlink("http://www.baidu.com/", new Button("OpenLink"));

        TextField textField = new TextField();
        Button button = new Button("SetLink");

        hyperlink.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                HostServices hostServices = Main.this.getHostServices();

                hostServices.showDocument(hyperlink.getText());
            }
        });

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                hyperlink.setText(textField.getText());
            }
        });

        vBox.getChildren().addAll(hyperlink, textField, button);

        Scene scene = new Scene(vBox);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Miko is lovely AI?");
        primaryStage.setWidth(700);
        primaryStage.setHeight(550);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
