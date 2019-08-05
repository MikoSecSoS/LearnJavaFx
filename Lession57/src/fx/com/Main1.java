package fx.com;

import javafx.application.Application;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        SimpleIntegerProperty a = new SimpleIntegerProperty(0);
        SimpleIntegerProperty b = new SimpleIntegerProperty(0);

        BooleanBinding booleanBinding = a.greaterThan(b);

        HBox hBox1 = new HBox();

        ImageView imageView = new ImageView("img/bg.jpg");
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(800);

        hBox1.getChildren().add(imageView);

        HBox hBox2 = new HBox();
        ImageView imageView1 = new ImageView("img/bg_gril.png");
        imageView1.setPreserveRatio(true);
        imageView1.setFitWidth(800);
        hBox2.getChildren().add(imageView1);


        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color: #0FFFFF");

        TextField textField = new TextField();
        TextField textField1 = new TextField();

        Button button = new Button("[If Cute]");

        HBox hBox = new HBox(10);

        hBox.getChildren().addAll(textField, textField1, button);

        anchorPane.getChildren().addAll(hBox1, hBox);

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Miko is lovely AI?");
        primaryStage.setWidth(800);
        primaryStage.setHeight(650);
        primaryStage.show();

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (textField.getText().isEmpty() || textField.getText().isEmpty() ||
                    !textField.getText().matches("[0-9]+") ||
                    !textField1.getText().matches("[0-9]+")) {
                    System.out.println(textField.getText());
                    System.out.println(textField1.getText());
                    return;
                }

                int value_a = Integer.parseInt(textField.getText());
                int value_b = Integer.parseInt(textField1.getText());

                a.set(value_a);
                b.set(value_b);

                if (booleanBinding.get()) {
                    anchorPane.getChildren().set(0, hBox1);
                } else {
                    anchorPane.getChildren().set(0, hBox2);
                }
            }
        });

    }
}
