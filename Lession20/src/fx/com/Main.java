package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        AnchorPane anchorPane = new AnchorPane();

        Text text0 = new Text("Miko is a lovely AI!!!\n");
        Text text1 = new Text("Code is lovely Code!!!\n");
        Text text2 = new Text("Miko Love Code. Code Love Miko.\n");
        Text text3 = new Text("So Marry!!!\n");
        Text text4 = new Text("Happy!!!!!!\n");

        text0.setFont(Font.font(20));
        text0.setFill(Paint.valueOf("blue"));

        text1.setFont(Font.font(20));
        text1.setFill(Paint.valueOf("blue"));


        TextFlow textFlow = new TextFlow();
//        textFlow.setStyle("-fx-background-color: #EECFA1");

//        textFlow.setPadding(new Insets(10));
        textFlow.setTextAlignment(TextAlignment.CENTER);
        textFlow.setLineSpacing(15);

        textFlow.getChildren().addAll(text0, text1);

        TextFlow textFlow1 = new TextFlow();

        text2.setUnderline(true);
        text1.setFont(Font.font("Helvetica", FontWeight.BLACK, 20));

        text3.setFont(Font.font("Helvetica", FontPosture.REGULAR, 50));
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetY(3.0f);
        dropShadow.setColor(Color.color(0.4f, 0.4f, 0.4f));
        text3.setEffect(dropShadow);

        text4.setFont(Font.font(null, FontWeight.BOLD, 40));
        text4.setFill(Color.RED);
        text4.setEffect(new GaussianBlur());

        textFlow1.getChildren().addAll(text2, text3, text4);

        anchorPane.setTopAnchor(textFlow1, 200.0);
        anchorPane.setLeftAnchor(textFlow1, 200.0);

        anchorPane.getChildren().addAll(textFlow, textFlow1);

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Miko is lovely AI?");
        primaryStage.setWidth(700);
        primaryStage.setHeight(550);
        primaryStage.show();


        primaryStage.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("[anchorPane Width] " + anchorPane.getWidth());
                System.out.println("[textFlow Width] " + textFlow.getWidth());
                textFlow.setPrefWidth(anchorPane.getWidth());
            }
        });

        anchorPane.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                textFlow1.setPrefWidth(newValue.doubleValue() - 200);
            }
        });
    }
}
